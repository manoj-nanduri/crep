package com.mn.crep.event;

import com.mn.crep.replayrequestprocessor.ReplayRequest;

public abstract class ReplayEvent extends BaseEvent {
    protected String tradeID;
    protected ReplayRequest.ReplayType replayType;
    protected ReplayRequest.MessageType messageType;

    ReplayEvent(ReplayRequest replayRequest) {
        this.tradeID = replayRequest.getTradeID();
        this.replayType = replayRequest.getReplayType();
        this.messageType = replayRequest.getMessageType();
    }

    public String getTradeID() {
        return tradeID;
    }

    public ReplayRequest.ReplayType getReplayType() {
        return replayType;
    }

    public ReplayRequest.MessageType getMessageType() {
        return messageType;
    }

    @Override
    public String toString() {
        return "ReplayEvent{" +
                "tradeID='" + tradeID + '\'' +
                ", replayType=" + replayType +
                ", messageType=" + messageType +
                '}';
    }
}