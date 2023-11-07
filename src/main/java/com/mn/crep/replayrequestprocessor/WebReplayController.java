package com.mn.crep.replayrequestprocessor;

import com.mn.crep.exception.InvalidFormatException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

@Controller
public class WebReplayController {
    @Autowired
    private ReplayRequestProcessor replayRequestProcessor;

    @GetMapping("/")
    public String index() {
        return "redirect:/upload";
    }

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        return "upload";
    }

    @PostMapping("/upload")
    public String processReplayRequests(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            Set<ReplayRequest> replayRequests = parseCsvFile(file);
            Object result = replayRequestProcessor.processReplayRequests(replayRequests);

            redirectAttributes.addFlashAttribute("message", "Replay request submitted successfully.");
        } catch (InvalidFormatException e) {
            redirectAttributes.addFlashAttribute("error", "There was an issue processing your file: " + e.getMessage());
            return "redirect:/upload";
        }

        return "redirect:/upload";
    }

    private Set<ReplayRequest> parseCsvFile(MultipartFile file) throws InvalidFormatException {
        Set<ReplayRequest> replayRequests = new HashSet<>();

        try (Reader reader = new InputStreamReader(file.getInputStream());
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                String tradeID = record.get("TradeID");
                String messageTypeStr = record.get("MessageType");
                String replayTypeStr = record.get("ReplayType");

                if (tradeID == null || tradeID.trim().isEmpty() ||
                        messageTypeStr == null || messageTypeStr.trim().isEmpty() ||
                        replayTypeStr == null || replayTypeStr.trim().isEmpty()) {
                    throw new InvalidFormatException("CSV file format is invalid. All fields must be present and not empty.");
                }

                ReplayRequest.ReplayType replayType;
                ReplayRequest.MessageType messageType;
                try {
                    replayType = ReplayRequest.ReplayType.valueOf(replayTypeStr);
                    messageType = ReplayRequest.MessageType.valueOf(messageTypeStr);
                } catch (IllegalArgumentException e) {
                    throw new InvalidFormatException("Invalid MessageType or ReplayType in CSV file.");
                }

                ReplayRequest request = new ReplayRequest(tradeID, replayType, messageType);
                replayRequests.add(request);
            }
        } catch (IOException e) {
            throw new InvalidFormatException("Error reading CSV file.", e);
        }
        return replayRequests;
    }
}