package com.mn.crep.replayrequestprocessor;

import com.mn.crep.event.EventFactory;
import com.mn.crep.eventpublisher.EventPublisher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReplayRequestProcessor {

    @Autowired
    private EventPublisher eventPublisher;
    private static final Logger logger = LogManager.getLogger(ReplayRequestProcessor.class);

    public Object processReplayRequests(Set<ReplayRequest> replayRequests) {
        for (ReplayRequest replayRequest : replayRequests) {
            handleReplayRequest(replayRequest);
        }
        return "Replay requests processed successfully.";
    }
    private void handleReplayRequest(ReplayRequest replayRequest){
        eventPublisher.publish(EventFactory.createReplayEvent(replayRequest));
        logger.debug("[" + replayRequest.getTradeID() +"] -- ReplayEvent Published from ReplayRequestProcessor via EventFactory for TradeID: " + replayRequest.getTradeID()  + " and ReplayType = " + replayRequest.getReplayType());
    }
}
