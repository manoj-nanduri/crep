package com.mn.crep.replayrequestprocessor;

import com.mn.crep.replayrequestprocessor.ReplayRequest;
import com.mn.crep.replayrequestprocessor.ReplayRequestProcessor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1")
public class ReplayRequestController {

    @Autowired
    private ReplayRequestProcessor replayRequestProcessor;

    @PostMapping("/replays")
    public ResponseEntity<?> processReplayRequests(@Valid @RequestBody Set<ReplayRequest> replayRequests) {
        return ResponseEntity.ok(replayRequestProcessor.processReplayRequests(replayRequests));
    }
}
