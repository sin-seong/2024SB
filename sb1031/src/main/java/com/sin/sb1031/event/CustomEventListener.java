package com.sin.sb1031.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
public class CustomEventListener {
    @EventListener
    public void handleCustomEvent(CustomEvent customEvent) {
        log.info("핸들링 콘텍스트 스탓드 이벤트. message:{}", customEvent.getMessage());
    }
}
