package com.mvcCrypto.mvcCrypto.controller;

import com.mvcCrypto.mvcCrypto.controller.service.UserService;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {
    @Autowired
    UserService us;

    @GetMapping("/profile")
    public String formProfile(Model model){
        User user=us.getOne(us.getGmailActualSesion()); //el usuario en sesión actual
        model.addAttribute("user", user);
        return "Profile";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, RedirectAttributes redirect, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                return "Profile";
            }
            user.setId_user(us.getOne(us.getGmailActualSesion()).getId_user());
            user.setGmail(us.getOne(us.getGmailActualSesion()).getGmail());
            us.update(user);
            redirect.addFlashAttribute("message", "Datos de perfil editados correctamente.")
                    .addFlashAttribute("active", "success");
            return "redirect:/app-view";
        }catch (Exception e){
            redirect.addFlashAttribute("message", "Fallo al intentar editar los datos.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/update";
        }
    }
}
