# crep
Mock code for ReplayService

TEMP

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfiguration {

    @Bean
    @ConditionalOnProperty(name = "events.implementation.type", havingValue = "spring-events")
    public EventPublisher springEventPublisher() {
        return new SpringEventPublisher();
    }

    @Bean
    @ConditionalOnProperty(name = "events.implementation.type", havingValue = "kafka")
    public EventPublisher kafkaEventPublisher() {
        return new KafkaEventPublisher();
    }

    @Bean
    @ConditionalOnProperty(name = "events.implementation.type", havingValue = "spring-events")
    public EventHandler springEventHandler() {
        return new SpringEventHandler();
    }

    @Bean
    @ConditionalOnProperty(name = "events.implementation.type", havingValue = "kafka")
    public EventHandler kafkaEventHandler() {
        return new KafkaEventHandler();
    }
}

