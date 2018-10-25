package com.development.ordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("message", "This is welcome page!");
        return "welcome";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("message", "This is welcome page!");
        return "login";
    }

    @RequestMapping(value = { "/admin_page"}, method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("message", "This is Admin page!");
        return "admin_page";
    }

    @RequestMapping(value = { "/user_page" }, method = RequestMethod.GET)
    public String userPage(Model model) {
        model.addAttribute("message", "This is User page!");
        return "user_page";
    }
}
