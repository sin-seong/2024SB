package com.sin.sb1031.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEventPublisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void doStuffAndPublish(final String message) {
        System.out.println("퍼블리싱 커스텀 이벤트: ");
        CustomEvent event = new CustomEvent(this, message);
        publisher.publishEvent(event);
    }
}
