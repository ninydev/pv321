package org.itstep.first.modules.ws;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @MessageMapping("/notify") // Клиент отправляет данные на /app/notify
    @SendTo("/topic/notifications") // Все клиенты, подписанные на /topic/notifications, получат сообщение
    public String sendNotification(String message) {
        return "Новое уведомление: " + message;
    }
}