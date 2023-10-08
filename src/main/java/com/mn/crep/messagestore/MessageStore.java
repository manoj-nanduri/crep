package com.mn.crep.messagestore;

import com.mn.crep.message.DownstreamMessage;

public interface MessageStore {
    DownstreamMessage retrieveMessage(String tradeId);
}
