package com.mn.crep.event;

import com.mn.crep.replayrequestprocessor.ReplayRequest;

public class MessageCorrectionEvent extends ReplayEvent{

    MessageCorrectionEvent(ReplayRequest replayRequest) {
        super(replayRequest);
    }
}
