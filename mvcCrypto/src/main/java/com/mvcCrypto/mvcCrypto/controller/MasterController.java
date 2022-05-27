package com.mvcCrypto.mvcCrypto.controller;


import com.mvcCrypto.mvcCrypto.controller.repository.CoinExternoRepository;
import com.mvcCrypto.mvcCrypto.controller.service.CoinApiService;

import com.mvcCrypto.mvcCrypto.controller.service.CoinExternoService;
import com.mvcCrypto.mvcCrypto.controller.service.TransactionService;

import com.mvcCrypto.mvcCrypto.controller.service.UserCoinService;
import com.mvcCrypto.mvcCrypto.model.CoinAdapter;
import com.mvcCrypto.mvcCrypto.model.Transaction;
import com.mvcCrypto.mvcCrypto.model.User;
import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/login")
    public String login(Model model) {
        return "Login";
    }

        @GetMapping("")
    public String getAll(Model model) {

        try {
/*
ArrayList<Object> array= new ArrayList<>();
ArrayList<CoinAdapter> array2= new ArrayList<>();
ArrayList<Object> array3= new ArrayList<>();

array =ces.getAll();
array2 = cas.getAll();


for(int i=0;i<array2.size();i++){
    //array3.add(ces.getByName(array2.get(i).getId_coin()));
}
//array3.add(ces.getByName(cas.getOne("BTC").getId_coin()));
array3.add(ces.getByName("BTC"));
*/
    model.addAttribute("coins",ces.getAll());
    model.addAttribute("transaction", new Transaction());
    model.addAttribute("user_coin", new User_Coin());
    model.addAttribute("movs",ts.getAll());
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
    public  String withdraw(@ModelAttribute("user_coin") User_Coin user_coin){
        try{
         User_Coin uc = new User_Coin();
         Transaction tra=new Transaction();


            uc.setBalance(user_coin.getBalance());
            uc.setId_user_userCoin(user_coin.getId_user_userCoin());
            uc.setId_coin_userCoin(user_coin.getId_coin_userCoin());


            tra.setType(true);
            tra.setDate(new Timestamp(System.currentTimeMillis()));
            tra.setBalance(user_coin.getBalance());
            tra.setId_user(user_coin.getId_user_userCoin());
            tra.setId_coin(user_coin.getId_coin_userCoin());
            tra.setId_destination_user(user_coin.getId_user_userCoin());
            tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin_userCoin().getId_coin().toLowerCase())); //llamada a api externa

            ts.save(tra);
            ts.depositar(uc);

            //redirect.addFlashAttribute("message", "Retiro realizado correctamente." )
            //       .addFlashAttribute("class", "success");
            return "redirect:/";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            //redirect.addFlashAttribute("message", "Falló el intento de retiro." )
            //        .addFlashAttribute("class", "danger");
            return "redirect:/";
        }
    }


       /* @GetMapping("/{name}")
        public String findByName (Model model, @PathVariable("name") String name){

            model.addAttribute("coinName", ces.getByName(name));


            return "Index";
        }*/

}
