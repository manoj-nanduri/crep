package com.mn.crep.event;

import com.mn.crep.replayrequestprocessor.ReplayRequest;

public class MessageResendEvent extends ReplayEvent{
    MessageResendEvent(ReplayRequest replayRequest) {
        super(replayRequest);
    }
}
