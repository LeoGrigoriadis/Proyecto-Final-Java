package com.mvcCrypto.mvcCrypto.controller;

import com.mvcCrypto.mvcCrypto.controller.service.UserService;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class UserController {

    @Autowired
    UserService uS;
    @GetMapping()
    public String login(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);

        return ("UserTemplates/Login");
    }
    @PostMapping("/login")
    public String loginVer(@ModelAttribute("user") @Valid User user)
    {
        User u = uS.getByEmail(user.toString());
        if(u != null) {
/*
            if (!user.getPassword().equals(u.getPassword()))
            {
                return "redirect:/";
            }
            else
            {
                if (!u.isAdmin()) {
                    return "redirect:/vehicles/userIndex";
                } else {
                    return "redirect:/vehicles";
                }

            }
            */

        }
        return "redirect:/";
    }
    @GetMapping("/signUp")
    public String signUp(Model model)
    {
        User user = new User();
       // user.setAdmin(false);
        model.addAttribute("user", user);

        return ("UserTemplates/signUp");
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("user") @Valid User user)
    {
        User u = uS.getByEmail(user.toString());
        if(u == null) {
            uS.save(user);
            return "redirect:/";
        }
        else {
            return "redirect:/signUp";
        }

    }
}
