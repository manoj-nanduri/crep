package com.mn.crep.replayrequestprocessor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ReplayRequest {

    @NotEmpty
    private String tradeID;

    @NotNull
    private ReplayType replayType;

    @NotNull
    private MessageType messageType;

    public ReplayRequest(String tradeID, ReplayType replayType, MessageType messageType) {
        this.tradeID = tradeID;
        this.replayType = replayType;
        this.messageType = messageType;
    }

    public String getTradeID() {
        return tradeID;
    }

    public ReplayType getReplayType() {
        return replayType;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public enum ReplayType {
        CORRECTION, RESEND
    }

    public enum MessageType {
        VALUATION, POSITION, TRANSACTION_HISTORY
    }

    @Override
    public String toString() {
        return "ReplayRequest{" +
                "tradeID='" + tradeID + '\'' +
                ", replayType=" + replayType +
                ", messageType=" + messageType +
                '}';
    }
}
