package com.example.ElSchool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class MainController {
    @GetMapping("/form")
    public String showForm(){
        return "authForm";
    }

    @PostMapping("/form")
    public String saveForm(@RequestParam(value = "login") String login , @RequestParam(value = "pass") String password){
        if(Objects.equals(login, "admin") && Objects.equals(password, "admin")){
            return "redirect:/home";
        }
        return "authForm";
    }

}
