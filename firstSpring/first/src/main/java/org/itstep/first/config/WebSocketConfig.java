package org.itstep.first.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // Основная точка подключения WebSocket
                .setAllowedOriginPatterns("*") // Разрешаем все источники (в проде лучше настроить CORS)
                .withSockJS(); // Включаем поддержку SockJS для браузеров, не поддерживающих WebSocket
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // Включаем брокер сообщений на /topic
        registry.setApplicationDestinationPrefixes("/app"); // Префикс для сообщений от клиента
    }
}
