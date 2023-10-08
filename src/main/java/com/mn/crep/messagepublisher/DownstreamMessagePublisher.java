package com.mn.crep.messagepublisher;

import com.mn.crep.message.DownstreamMessage;

public interface DownstreamMessagePublisher {
    void publish(DownstreamMessage downstreamMessage);
}
