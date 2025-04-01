package org.itstep.first.modules.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Logger logger = LoggerFactory.getLogger(MessageProducer.class);


    private final String queueName = "myQueue";

    private final String exchangeName = "myExchange";

    private final String routingKey = "myRoutingKey";

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchangeName,
                routingKey, message);
        logger.info("Отправлено сообщение: {}", message);
    }
}
