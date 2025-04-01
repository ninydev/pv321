package org.itstep.first.controllers;

import org.itstep.first.modules.rabbit.MessageProducer;
import org.itstep.first.modules.redis.RedisMessagePublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPageController {

    private final RedisMessagePublisher redisMessagePublisher;
    private final MessageProducer messageProducer;

    public StaticPageController(
            RedisMessagePublisher redisMessagePublisher,
            MessageProducer messageProducer) {
        this.redisMessagePublisher = redisMessagePublisher;
        this.messageProducer = messageProducer;
    }

    @GetMapping("/about")
    public String about() {
        return "pages/about";
    }

    @GetMapping("/")
    public String home() {
        // Send a message to RabbitMQ
        messageProducer.sendMessage("Home page accessed");
        // Publish a message to Redis
        redisMessagePublisher.publishMessage("home_channel",
                "Home page accessed");
        return "pages/home";
    }


    @GetMapping("/contact")
    public String contact() {
        return "pages/contact";
    }
}
