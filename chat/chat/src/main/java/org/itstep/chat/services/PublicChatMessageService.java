package org.itstep.chat.services;


import org.itstep.chat.entities.PublicChatMessageModel;
import org.itstep.chat.repositories.PublicChatMessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PublicChatMessageService {

    private final PublicChatMessageRepository messageRepository;

    public PublicChatMessageService(PublicChatMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Получить все сообщения с пагинацией
    public Page<PublicChatMessageModel> getAllMessages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return messageRepository.findAll(pageable);
    }


    // Сохранить новое сообщение
    @Transactional
    public PublicChatMessageModel saveMessage(PublicChatMessageModel message) {
        return messageRepository.save(message);
    }


}

