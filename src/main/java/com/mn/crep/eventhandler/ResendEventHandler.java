package com.mn.crep.eventhandler;

import com.mn.crep.event.BaseEvent;
import com.mn.crep.event.MessageResendEvent;
import com.mn.crep.message.DownstreamMessage;
import com.mn.crep.messagepublisher.DownstreamMessagePublisher;
import com.mn.crep.replayrequestprocessor.ReplayRequestProcessor;
import com.mn.crep.messagestore.MessageStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ResendEventHandler implements EventHandler {

    private static final Logger logger = LogManager.getLogger(ReplayRequestProcessor.class);

    @Autowired
    private MessageStore messageStore;

    @Autowired
    private DownstreamMessagePublisher downstreamMessagePublisher;

    @Override
    @EventListener
    @Async
    public void handleEvent(BaseEvent event) {
        if(event instanceof MessageResendEvent){
            handleMessageResendEvent((MessageResendEvent) event);
        }
    }

    private void handleMessageResendEvent(MessageResendEvent messageResendEvent) {
        logger.debug("[" + messageResendEvent.getTradeID() + "] -- Handling Message Resend Event from ResendEventHandler");

        DownstreamMessage message = messageStore.retrieveMessage(messageResendEvent.getTradeID());
        logger.debug("[" + messageResendEvent.getTradeID() + "] -- Retrieved Message from Store - " + message);

        downstreamMessagePublisher.publish(message);
    }


}
