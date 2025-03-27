package org.itstep.first.modules.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/by_session")
public class UserSessionController {

    private static final Logger logger = LoggerFactory.getLogger(UserSessionController.class);

    @GetMapping
    public String show(HttpServletRequest request) {
        logger.info("Session Id: " + request.getSession().getId());
        return "by_session/index";
    }

    @PostMapping
    public  String start(HttpServletRequest request) {

        // Создаем сессию
        HttpSession session = request.getSession(true); // Создаем сессию
        logger.info("Session Id: " + request.getSession().getId());

        return "redirect:/by_session";
    }

}
