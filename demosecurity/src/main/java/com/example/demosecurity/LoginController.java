package com.example.demosecurity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/auth")
    public String handle(ModelMap modelMap) {
        modelMap.addAttribute("LoginForm", new LoginForm());
        return "login";
    }

    @GetMapping("/top")
    public String success(ModelMap modelMap) {
        return "top";
    }

    @GetMapping("/failure")
    public String failure(ModelMap modelMap) {
        modelMap.addAttribute("isError", true);
        modelMap.addAttribute("LoginForm", new LoginForm());
        return "login";
    }
}
