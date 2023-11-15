# crep
Mock code for ReplayService

TEMP

CODE
package event.config;

import event.handler.EventHandler;
import event.handler.ResendEventHandler;
import event.handler.SimpleResendEventHandler;
import event.publisher.EventPublisher;
import event.publisher.ReplayEventPublisher;
import event.publisher.SimpleReplayEventPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

    @Value("${application.event.mechanism}")
    private String eventMechanism;

    @Bean
    public EventHandler resendEventHandler() {
        if ("kafka".equals(eventMechanism)) {
            return new ResendEventHandler();
        } else {
            return new SimpleResendEventHandler();
        }
    }

    @Bean
    public EventPublisher replayEventPublisher() {
        if ("kafka".equals(eventMechanism)) {
            return new ReplayEventPublisher();
        } else {
            return new SimpleReplayEventPublisher();
        }
    }
}


