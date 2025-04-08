package org.itstep.chat.repositories;


import org.itstep.chat.entities.PublicChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface PublicChatMessageRepository extends JpaRepository<PublicChatMessageModel, Long> {

    // Метод для получения сообщений с пагинацией
    Page<PublicChatMessageModel> findAll(Pageable pageable);

    // Метод для получения сообщений по автору
    List<PublicChatMessageModel> findByAuthorId(Long authorId);

    // Метод для получения сообщений в определенном порядке (например, по дате создания)
    List<PublicChatMessageModel> findByOrderByCreatedAtAsc();

    // Можно добавить другие методы для поиска по условиям (например, фильтрация по типу)
    List<PublicChatMessageModel> findByMessageTypeOrderByCreatedAtDesc(PublicChatMessageModel.MessageType messageType);
}