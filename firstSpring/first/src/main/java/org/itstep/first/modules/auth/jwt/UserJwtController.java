package org.itstep.first.modules.auth.jwt;


import jakarta.servlet.http.HttpSession;
import org.itstep.first.modules.auth.common.LoginUserDto;
import org.itstep.first.modules.auth.common.UserModel;
import org.itstep.first.modules.auth.common.UserService;
import org.itstep.first.modules.auth.session.UserSessionController;
import org.itstep.first.modules.auth.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/by_jwt")
public class UserJwtController {

    private static final Logger logger = LoggerFactory.getLogger(UserJwtController.class);
    private final UserService userService;

    public UserJwtController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index() {
        return "by_jwt/index";
    }

    @PostMapping
    public String login(Model model, LoginUserDto userDto) {

        UserModel user = userService.findByCred(userDto.getEmail(), userDto.getPassword());
        if (user == null) {
            logger.info("User not found");
            return "redirect:by_jwt/index?error=invalid_credentials";
        }

        String accessToken = JwtUtil.generateAccessToken(user.getEmail());
        String refreshToken = JwtUtil.generateRefreshToken(user.getEmail());

        logger.info("Generated access token: {}", accessToken);
        logger.info("Generated refresh token: {}", refreshToken);

        model.addAttribute("accessToken", accessToken);
        model.addAttribute("refreshToken", refreshToken);

        return "by_jwt/index";
    }
}
