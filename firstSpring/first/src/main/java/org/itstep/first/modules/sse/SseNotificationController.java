package org.itstep.first.modules.sse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class SseNotificationController {

    @GetMapping("/sse")
    public SseEmitter streamNotifications() {
        SseEmitter emitter = new SseEmitter(0L); // Бесконечный таймаут
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(() -> {
            try {
                emitter.send("Новое уведомление в "
                        + LocalTime.now());
            } catch (IOException e) {
                emitter.complete();
            }
        }, 0, 10, TimeUnit.SECONDS); // Отправлять каждое уведомление раз в 15 секунд

        return emitter;
    }
}
