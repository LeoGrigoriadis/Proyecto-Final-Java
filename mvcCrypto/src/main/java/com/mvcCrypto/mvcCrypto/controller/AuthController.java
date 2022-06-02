package com.mvcCrypto.mvcCrypto.controller;

import com.mvcCrypto.mvcCrypto.controller.service.AuthService;
import com.mvcCrypto.mvcCrypto.controller.service.UserCoinService;
import com.mvcCrypto.mvcCrypto.controller.service.UserService;
import com.mvcCrypto.mvcCrypto.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping
public class AuthController {

    @Autowired
    private AuthService aS;

    @Autowired 
    private UserService us;

    @Autowired
    private UserCoinService ucs;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @GetMapping("/register")
    public String signUpget(Model model) {
        model.addAttribute("user", new UserAdapter());
        return "Register";
    }
    
    @PostMapping("/register")
    public String SignUp(@Valid @ModelAttribute("user")UserAdapter uA, RedirectAttributes redirect, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return "Register";
            }
            User gmail = us.getOne(uA.getGmail());

            if (gmail != null) {
                redirect.addFlashAttribute("message", "Gmail already in use")
                        .addFlashAttribute("active", "danger");
                return "redirect:/register";
            } else {
                Role role = new Role();
                role.setId_role(1);
                role.setName("user");
                Auth auth = new Auth(uA.getGmail(), encoder.encode(uA.getPassword()), role);
                aS.save(auth);

                User user = new User();
                user.setFirst_name(uA.getFirstName());
                user.setLast_name(uA.getLastName());
                user.setBirthday(uA.getBirthday());
                user.setGmail(auth);
                us.save(user);

                CoinAdapter coin1 = new CoinAdapter("btc", "Bitcoin");
                CoinAdapter coin2 = new CoinAdapter("eth", "Ethereum");
                CoinAdapter coin3 = new CoinAdapter("usdt", "Tether");
                CoinAdapter coin4 = new CoinAdapter("usdc", "USD Coin");
                User_Coin u = new User_Coin(0, coin1, 0, us.getOne(uA.getGmail()));
                ucs.save(u);
                u.setId_coin(coin2);
                ucs.save(u);
                u.setId_coin(coin3);
                ucs.save(u);
                u.setId_coin(coin4);
                ucs.save(u);
                redirect.addFlashAttribute("message", "User created Successfully")
                        .addFlashAttribute("active", "success");
                return "redirect:/login";
            }
        }catch (Exception e){
            redirect.addFlashAttribute("message", "User creation error")
                    .addFlashAttribute("active", "danger");
            return "redirect:/register";
        }
    }
}
