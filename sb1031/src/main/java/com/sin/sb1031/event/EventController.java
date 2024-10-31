package com.sin.sb1031.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class EventController {

        private final CustomEventPublisher customEventPublisher;

        @GetMapping("/event/{msg}")
    public void event(@PathVariable String msg) {
            log.info(msg);
            customEventPublisher.doStuffAndPublish("이벤트 테스트:"+ msg);
        }
}
