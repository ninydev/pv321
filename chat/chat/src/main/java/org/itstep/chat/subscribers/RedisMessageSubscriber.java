package org.itstep.chat.subscribers;

import org.itstep.chat.sse.SsePublicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener {

    private final Logger logger = LoggerFactory.getLogger(RedisMessageSubscriber.class);
    private final SsePublicService ssePublicService;

    public RedisMessageSubscriber(SsePublicService ssePublicService) {
        this.ssePublicService = ssePublicService;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String receivedMessage = new String(message.getBody());
        logger.info("\uD83D\uDCE9 Получено сообщение: {}", receivedMessage);
        // ssePublicService.sendNotification("Redis: " + receivedMessage);
    }

}
