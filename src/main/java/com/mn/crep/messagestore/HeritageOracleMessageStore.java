package com.mn.crep.messagestore;

import com.mn.crep.message.DownstreamMessage;
import com.mn.crep.message.XMLDownstreamMessage;
import org.springframework.stereotype.Service;

@Service
public class HeritageOracleMessageStore implements MessageStore {

    @Override
    public DownstreamMessage retrieveMessage(String tradeId) {
        String xmlData = "<xml>XMLDownstreamMessage for " + tradeId + "</xml>";
        return new XMLDownstreamMessage(xmlData);
    }
}
