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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String SignUp(@ModelAttribute("user")UserAdapter uA, RedirectAttributes redirect) {

        User gmail =  us.getOne(uA.getGmail());
        
         if(gmail!= null){
            redirect.addFlashAttribute("message", "Gmail already in use")
                    .addFlashAttribute("active", "danger");
            return "redirect:/register";
        }else{
            Role role = new Role();
            role.setId_role(1);
            role.setName("user");
            Auth auth = new Auth(uA.getGmail(), encoder.encode(uA.getPassword()),role);
            aS.save(auth);

            User user = new User();
            user.setFirst_name(uA.getFirstName());
            user.setLast_name(uA.getLastName());
            user.setBirthday(uA.getBirthday());
            user.setGmail(auth);
            us.save(user);

            setUser_Coins(user);

            redirect.addFlashAttribute("message", "User created Successfully")
                    .addFlashAttribute("active", "success");
            return "redirect:/login";
         }

    }
    public void setUser_Coins(User user){
        System.out.println(user);
        CoinAdapter coin1= new CoinAdapter();
        coin1.setId_coin("btc");
        coin1.setName("Bitcoin");
        CoinAdapter coin2= new CoinAdapter();
        coin2.setId_coin("eth");
        coin2.setName("Ethereum");
        CoinAdapter coin3= new CoinAdapter();
        coin3.setId_coin("usdt");
        coin3.setName("Tether");
        CoinAdapter coin4= new CoinAdapter();
        coin4.setId_coin("usdc");
        coin4.setName("USD Coin");
        System.out.println(coin1);

        System.out.println(new User_Coin(0, coin1, 0,user));
        ucs.save(new User_Coin(0, coin1, 0,user));
        ucs.save(new User_Coin(0, coin2, 0,user));
        ucs.save(new User_Coin(0, coin3, 0,user));
        ucs.save(new User_Coin(0, coin4, 0,user));
    }


/*
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
      */

}
