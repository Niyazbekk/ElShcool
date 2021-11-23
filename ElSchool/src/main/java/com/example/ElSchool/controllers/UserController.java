package com.example.ElSchool.controllers;


import com.example.ElSchool.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class UserController {
    private UsersCont usersCont;


    @Autowired
    public void setUsersCont(UsersCont usersCont) {
        this.usersCont = usersCont;
    }

    @GetMapping
    public String showStudentList(Model model) {
        Users user = new Users();
        model.addAttribute("users", usersCont.getAll());
        model.addAttribute("user", user);
        return "home";
    }

    @PostMapping
    public String addStudent(Users user) {
        usersCont.update(user.getName() , user.getSub_class());
        return "redirect:/home";
    }


    @GetMapping("/deleteHome")
    public String showDeletePage() {
        return "deleteHome";
    }

    @PostMapping("/deleteHome")
    public String deleteStudent(@RequestParam(value = "name")String name) {
        usersCont.delete(name);
        return "redirect:/home";
    }
}
