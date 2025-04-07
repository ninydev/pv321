package org.itstep.chat.sse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SsePublicService {
    private final List<SseEmitter> emitters =
            new CopyOnWriteArrayList<>();

    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(0L); // Бесконечный таймаут
        emitters.add(emitter);

        // Удаляем emitter при разрыве соединения
        emitter.onCompletion(() -> {
            someDisconnect();
            emitters.remove(emitter);});
        emitter.onTimeout(() -> {
            someDisconnect();
            emitters.remove(emitter);});

        someConnect();
        return emitter;
    }

    private void someDisconnect() {
        this.sendNotification("User disconnected. Count: "
                + emitters.size());
    }

    private void someConnect() {
        this.sendNotification("New use connected. Count: "
                + emitters.size());
    }

    public void sendNotification(String message) {
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().data(message));
            } catch (IOException e) {
                emitter.complete(); // Завершаем соединение при ошибке
                emitters.remove(emitter);
            }
        }
    }
}
