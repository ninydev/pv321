package org.itstep.first.modules.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    private final String queueName = "myQueue";

    private final String exchangeName = "myExchange";

    private final String routingKey = "myRoutingKey";

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        logger.info("✅ RabbitMQ Получено сообщение: {}", message);
    }
}
