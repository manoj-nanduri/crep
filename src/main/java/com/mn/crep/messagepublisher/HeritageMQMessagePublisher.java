package com.mn.crep.messagepublisher;

import com.mn.crep.message.DownstreamMessage;
import com.mn.crep.messagepublisher.DownstreamMessagePublisher;
import com.mn.crep.replayrequestprocessor.ReplayRequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class HeritageMQMessagePublisher implements DownstreamMessagePublisher {

    private static final Logger logger = LogManager.getLogger(ReplayRequestProcessor.class);
    @Override
    public void publish(DownstreamMessage downstreamMessage) {
        logger.debug("Publishing over MQ: " + downstreamMessage.getFormattedContent());
    }
}

