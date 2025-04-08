package org.itstep.chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicChatMessageController {

    @GetMapping("/public-chat")
    public String publicChat() {
        return "public-chat"; // Возвращаем имя шаблона для отображения
    }
}
