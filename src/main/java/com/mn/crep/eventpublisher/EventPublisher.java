package com.mn.crep.eventpublisher;

import com.mn.crep.event.BaseEvent;

public interface EventPublisher {
    void publish(BaseEvent event);
}
