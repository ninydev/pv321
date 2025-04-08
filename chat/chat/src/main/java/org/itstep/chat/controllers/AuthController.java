package org.itstep.chat.controllers;

import jakarta.validation.Valid;
import org.itstep.chat.dto.users.CreateUserDto;
import org.itstep.chat.mappers.UserMapper;
import org.itstep.chat.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class AuthController {

    private final UserService userService;
    private final Logger logger = Logger.getLogger(AuthController.class.getName());

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("createUserDto", new CreateUserDto());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid CreateUserDto createUserDto,
                               BindingResult result,
                               Model model) {
        logger.info("Registering new user: " + createUserDto);
        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            userService.save(UserMapper.INSTANCE.toModel(createUserDto));
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "auth/register";
        }

        return "redirect:/login";
    }

    @GetMapping ("/login")
    public String login() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginPost(CreateUserDto createUserDto) {
        return "redirect:/";
    }

    @GetMapping ("/logout")
    public String logout() {
        return "auth/logout";
    }

    @GetMapping("/profile")
    public String profile() {
        return "auth/profile";
    }
}
