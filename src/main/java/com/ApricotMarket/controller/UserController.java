package com.ApricotMarket.controller;

import com.ApricotMarket.domain.User;
import com.ApricotMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    // private final UserService userService;

    @GetMapping("/signin")
    public String getLogin() {
        System.out.println("controller: signinform");
        return "/signin";
    }

    @GetMapping("/signup")
    public String getSignUp() {
        System.out.println("controller: signupform");
        return "/signup";
    }

    @PostMapping("/signup")
    public String SignUp(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/mypage/customer")
    public String getCustomerMypage() {
        return "/mypage-customer";
    }

    @GetMapping("/mypage/seller")
    public String getSellerMypage() {
        return "/mypage-seller";
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }
}




