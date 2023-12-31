package com.mn.crep.event;

import com.mn.crep.replayrequestprocessor.ReplayRequest;

public class EventFactory {

     public static ReplayEvent createReplayEvent(ReplayRequest replayRequest) {
        switch (replayRequest.getReplayType()) {
            case CORRECTION:
                return new MessageCorrectionEvent(replayRequest);
            case RESEND:
                return new MessageResendEvent(replayRequest);
            default:
                throw new IllegalArgumentException("Invalid ReplayType: " + replayRequest.getReplayType());
        }
    }
}
