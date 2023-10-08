package com.mn.crep.eventpublisher;

import com.mn.crep.event.BaseEvent;
import com.mn.crep.replayrequestprocessor.ReplayRequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class InterimReplayEventPublisher implements EventPublisher{

    private static final Logger logger = LogManager.getLogger(ReplayRequestProcessor.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    @Async
    public void publish(BaseEvent event) {
        applicationEventPublisher.publishEvent(event);
        logger.debug("[" + event.toString() +"] -- Event Published from InterimReplayEventPublisher " + event.toString());
    }
}
