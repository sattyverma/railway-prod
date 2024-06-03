package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin123";

    @GetMapping("/loginn")
    public String showLoginForm() {
        return "AdminLogin";
    }

    @PostMapping("/loginn")
    public String login(@RequestParam("username") String username, 
                        @RequestParam("password") String password, 
                        HttpSession session) {
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            session.setAttribute("adminLoggedIn", true);
            return "redirect:/delete";
        } else {
            // Invalid credentials
            return "redirect:/loginn?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("adminLoggedIn");
        return "redirect:/admin/login?logout";
    }
    
    @GetMapping("/loginnn")
    public String showLoginform() {
        return "requestlogin";
    }

    @PostMapping("/loginnn")
    public String login1(@RequestParam("username") String Username, 
                        @RequestParam("password") String Password, 
                        HttpSession Session) {
        if (Username.equals(ADMIN_USERNAME) && Password.equals(ADMIN_PASSWORD)) {
            Session.setAttribute("adminLoggedIn", true);
            return "redirect:/book_register";
        } else {
            // Invalid credentials
            return "redirect:/loginnn?error";
        }
    }
 

}
