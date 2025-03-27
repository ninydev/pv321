package org.itstep.first.modules.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/by_session")
public class UserSessionController {

    private static final Logger logger = LoggerFactory.getLogger(UserSessionController.class);
    private final UserService userService;

    public UserSessionController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model, HttpServletRequest request) {

        UserModel user = null;

        if (request.getSession(false) != null) {
            logger.info("Session Id: " + request.getSession().getId());
            user = (UserModel) request.getSession().getAttribute("user");
            model.addAttribute("user", user);
        } else {
            logger.info("Session is not created");
        }

        return "by_session/index";
    }


    @PostMapping
    public String login(HttpServletRequest request, LoginUserDto userDto) {

        UserModel user = userService.findByEmail(userDto.getEmail());

        if (user != null && user.getPassword().equals(userDto.getPassword())) {
            // Создаем сессию
            HttpSession session = request.getSession(true); // Создаем сессию
            logger.info("Session Id: " + request.getSession().getId());
            session.setAttribute("user", user);
            return "redirect:/by_session";
        } else {
            return "redirect:/by_session?error=invalid_credentials";
        }
    }


//    @GetMapping
//    public String show(HttpServletRequest request) {
//        logger.info("Session Id: " + request.getSession().getId());
//        return "by_session/index";
//    }

//    @PostMapping
//    public  String start(HttpServletRequest request) {
//
//        // Создаем сессию
//        HttpSession session = request.getSession(true); // Создаем сессию
//        logger.info("Session Id: " + request.getSession().getId());
//
//        return "redirect:/by_session";
//    }

}
