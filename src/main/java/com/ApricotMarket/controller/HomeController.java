package com.ApricotMarket.controller;

import com.ApricotMarket.domain.User;
import com.ApricotMarket.service.ItemService;
import com.ApricotMarket.service.checkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private final ItemService itemService;
    public HomeController(ItemService itemService, checkService checkService) {
        this.itemService = itemService;
        this.checkService = checkService;
    }
    private final checkService checkService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("itemlist",itemService.recentItems());
        return "home";
    }

    @GetMapping("/introduce")
    public String introduce(){
        return "introduce";
    }

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("itemlist",itemService.recentItems());
        String username = checkService.currentUserName();
        User user = checkService.findUser(username).get();
        checkService.UserLogin(user.getId());
        return "home";
    }

    @PostMapping("/home")
    public String homeh(){
        return "home";
    }
}
