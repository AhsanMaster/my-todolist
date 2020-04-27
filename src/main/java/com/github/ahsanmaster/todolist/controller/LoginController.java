package com.github.ahsanmaster.todolist.controller;

import com.github.ahsanmaster.todolist.dto.UserDto;
import com.github.ahsanmaster.todolist.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) {
        logger.info("New user{}: " + userDto);
        if (result.hasErrors()) {
            return "register";
        }

        if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
            result.rejectValue("password", "", "Password not matching");
            return "register";
        }
        userService.create(userDto);
        return "redirect:/login";
    }
}
