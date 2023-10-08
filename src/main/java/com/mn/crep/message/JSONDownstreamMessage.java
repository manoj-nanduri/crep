package com.mn.crep.message;

public class JSONDownstreamMessage extends DownstreamMessage {

    public JSONDownstreamMessage(String content) {
        super(content);
    }

    @Override
    public String getFormattedContent() {
        // Any specific JSON formatting logic, if required
        return getContent();
    }
}