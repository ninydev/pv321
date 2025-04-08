package org.itstep.chat.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PublicChatMessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)  // Связь с пользователем
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel author;  // Автор сообщения

    @Column(nullable = false)
    private String messageText;  // Текст сообщения

    @Column(nullable = false)
    private LocalDateTime createdAt;  // Дата создания сообщения

    // Можно добавить поле для типа сообщения (например, обычное, системное)
    @Enumerated(EnumType.STRING)
    private MessageType messageType;  // Тип сообщения

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();  // Устанавливаем дату создания при сохранении
        }
    }

    public enum MessageType {
        TEXT, IMAGE, SYSTEM // Пример типов сообщений
    }
}
