package com.mvcCrypto.mvcCrypto.controller;


import com.mvcCrypto.mvcCrypto.controller.repository.CoinExternoRepository;
import com.mvcCrypto.mvcCrypto.controller.service.*;

import com.mvcCrypto.mvcCrypto.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class MasterController {

    @Autowired
    private CoinExternoService ces;
    @Autowired
    private CoinApiService cas;
    @Autowired
    private TransactionService ts;

    @Autowired
    private UserCoinService ucs;

    @Autowired
    private UserService us;

    @GetMapping("/login")
    public String login(Model model) {
        return "Login";
    }

    @GetMapping("/app-view")
    public String getAll(Model model) {
        try {
            User user=us.getOne(us.getGmailActualSesion()); //el usuario en sesión actual
            model.addAttribute("user",user);  //el usuario en sesión actual llevado a la vista
            model.addAttribute("coins",ces.getAll()); //criptos de api externa
            model.addAttribute("transaction", new Transaction()); //objeto para crear nueva transacción
            model.addAttribute("user_coin", new User_Coin()); //objeto para crear nueva transacción
            model.addAttribute("movs",ts.getAll(user.getId_user())); //lista de ultimos movimientos de la sesión actual
            model.addAttribute("wallet",ucs.findAllByIdUser(user.getId_user())); //wallet de la sesión actual
            return "AppView";
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return "AppView";
    }
    /*
    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute("transaction") Transaction tr, RedirectAttributes redirect){
        try{
            System.out.println(tr);
            tr.setType(true);
            tr.setId_user();
            tr.setDateTime(new Timestamp(System.currentTimeMillis()));
            tr.setPrice_in_transaction(ces.getAll().getAsk());
            System.out.println(tr);
            ts.save(tr);
            redirect.addFlashAttribute("message", "Retiro realizado correctamente." )
                    .addFlashAttribute("class", "success");
            return "redirect:/";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            redirect.addFlashAttribute("message", "Falló el intento de retiro." )
                    .addFlashAttribute("class", "danger");
            return "redirect:/";
        }
    }
*/
    @PostMapping("/withdraw")
    public  String withdraw(@ModelAttribute("user_coin") User_Coin user_coin,RedirectAttributes redirect){
        try{
            User_Coin uc = new User_Coin();
            Transaction tra=new Transaction();

            User user = us.getOne(us.getGmailActualSesion());
            user_coin.getId_coin_userCoin().setId_coin(user_coin.getId_coin_userCoin().getId_coin().toLowerCase());

            uc.setBalance(user_coin.getBalance());
            uc.setId_user_userCoin(user);
            uc.setId_coin_userCoin(user_coin.getId_coin_userCoin());

            tra.setType(true);
            tra.setDate(new Timestamp(System.currentTimeMillis()));
            tra.setBalance(user_coin.getBalance());
            tra.setId_user(user);
            tra.setId_coin(cas.getOne(user_coin.getId_coin_userCoin().getId_coin()));
            tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin_userCoin().getId_coin().toLowerCase())); //llamada a api externa
            ts.save(tra);
            ts.cobrar(uc);

            redirect.addFlashAttribute("message", "Retiro realizado correctamente." )
                   .addFlashAttribute("class", "success");
            return "redirect:/app-view";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            redirect.addFlashAttribute("message", "Falló el intento de retiro." )
                    .addFlashAttribute("class", "danger");
            return "redirect:/app-view";
        }
    }


    @PostMapping("/withdrawAll")
    public  String withdrawAll(@ModelAttribute("user_coin") User_Coin user_coin){
        try{
            User_Coin uc = new User_Coin();
            Transaction tra=new Transaction();


            uc.setBalance(user_coin.getBalance());
            uc.setId_user_userCoin(user_coin.getId_user_userCoin());
            uc.setId_coin_userCoin(user_coin.getId_coin_userCoin());


            tra.setType(true);
            tra.setDate(new Timestamp(System.currentTimeMillis()));
            tra.setBalance(user_coin.getBalance());
            User user =us.getById(user_coin.getId_user_userCoin().getId_user());
            //User user = us.getById(1);
            tra.setId_user(user);
            CoinAdapter coin = cas.getOne(user_coin.getId_coin_userCoin().getId_coin());
            tra.setId_coin(coin);
            tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin_userCoin().getId_coin().toLowerCase())); //llamada a api externa
            ts.save(tra);
            ts.depositar(uc);

            //redirect.addFlashAttribute("message", "Retiro realizado correctamente." )
            //       .addFlashAttribute("class", "success");
            return "redirect:/app-view";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            //redirect.addFlashAttribute("message", "Falló el intento de retiro." )
            //        .addFlashAttribute("class", "danger");
            return "redirect:/app-view";
        }
    }

    @PostMapping("/deposit")
    public  String deposit(@ModelAttribute("user_coin") User_Coin user_coin){
        try{
            User_Coin uc = new User_Coin();
            Transaction tra=new Transaction();


            uc.setBalance(user_coin.getBalance());
            uc.setId_user_userCoin(user_coin.getId_user_userCoin());
            uc.setId_coin_userCoin(user_coin.getId_coin_userCoin());


            tra.setType(true);
            tra.setDate(new Timestamp(System.currentTimeMillis()));
            tra.setBalance(user_coin.getBalance());
            User user =us.getById(user_coin.getId_user_userCoin().getId_user());
            //User user = us.getById(1);
            tra.setId_user(user);
            CoinAdapter coin = cas.getOne(user_coin.getId_coin_userCoin().getId_coin());
            tra.setId_coin(coin);
            tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin_userCoin().getId_coin().toLowerCase())); //llamada a api externa
            ts.save(tra);
            ts.depositar(uc);

            //redirect.addFlashAttribute("message", "Retiro realizado correctamente." )
            //       .addFlashAttribute("class", "success");
            return "redirect:/app-view";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            //redirect.addFlashAttribute("message", "Falló el intento de retiro." )
            //        .addFlashAttribute("class", "danger");
            return "redirect:/app-view";
        }
    }


       /* @GetMapping("/{name}")
        public String findByName (Model model, @PathVariable("name") String name){

            model.addAttribute("coinName", ces.getByName(name));


            return "Index";
        }*/

}
