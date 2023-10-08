package com.mn.crep.message;

public abstract class DownstreamMessage {
    private final String content;

    public DownstreamMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public abstract String getFormattedContent();

}
