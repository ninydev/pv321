package org.itstep.chat.config;

import org.itstep.chat.subscribers.RedisMessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {

    @Bean
    public RedisMessageListenerContainer
    redisContainer(RedisConnectionFactory connectionFactory,
                   RedisMessageSubscriber massageSubscriber,
                   RedisMessageSubscriber avatarSubscriber) {
        RedisMessageListenerContainer container =
                new RedisMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);

        container.addMessageListener(new
                MessageListenerAdapter(massageSubscriber),
                new PatternTopic("user_message"));

        container.addMessageListener(new
                        MessageListenerAdapter(avatarSubscriber),
                new PatternTopic("avatar_message"));

        return container;
    }
}