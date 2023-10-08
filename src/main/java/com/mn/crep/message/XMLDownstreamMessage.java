package com.mn.crep.message;

public class XMLDownstreamMessage extends DownstreamMessage {

    public XMLDownstreamMessage(String content) {
        super(content);
    }

    @Override
    public String getFormattedContent() {
        // Any specific XML formatting logic, if required
        return getContent();
    }
}