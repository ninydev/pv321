package org.itstep.chat.controllers;


import org.itstep.chat.entities.PublicChatMessageModel;
import org.itstep.chat.entities.UserModel;
import org.itstep.chat.services.PublicChatMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class ApiPublicChatMessageController {

    private final PublicChatMessageService messageService;
    private final Logger logger = LoggerFactory.getLogger(ApiPublicChatMessageController.class);


    public ApiPublicChatMessageController(PublicChatMessageService messageService) {
        this.messageService = messageService;
    }

    // Получить все сообщения с пагинацией
    @GetMapping
    public ResponseEntity<Page<PublicChatMessageModel>> getAllMessages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PublicChatMessageModel> messages = messageService.getAllMessages(page, size);
        return ResponseEntity.ok(messages);
    }

    // Создать новое сообщение
    @PostMapping
    public ResponseEntity<PublicChatMessageModel> createMessage(@RequestBody PublicChatMessageModel message) {
//        UserModel user = (UserModel) SecurityContextHolder.getContext().getAuthentication(); // Получаем user_id залогиненного пользователя
//        message.setAuthor(user);

        logger.info ("\n\nCreating message: {}", message);

        PublicChatMessageModel savedMessage = message;
        return ResponseEntity.ok(savedMessage);
    }
}

