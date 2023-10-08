package com.mn.crep.eventhandler;

import com.mn.crep.event.BaseEvent;
import com.mn.crep.event.MessageCorrectionEvent;
import com.mn.crep.replayrequestprocessor.ReplayRequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RealtimeReportingEventHandler implements EventHandler {

    private static final Logger logger = LogManager.getLogger(ReplayRequestProcessor.class);

    @Override
    @EventListener
    @Async
    public void handleEvent(BaseEvent event) {
        if(event instanceof MessageCorrectionEvent){
            handleMessageCorrectionEvent((MessageCorrectionEvent) event);
        }
    }

    public void handleMessageCorrectionEvent(MessageCorrectionEvent messageCorrectionEvent){
        logger.debug("[" + messageCorrectionEvent.getTradeID() + "] --- Handling Message Correction Event from RealtimeReportingEventHandler");
    }
}
