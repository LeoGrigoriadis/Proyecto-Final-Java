package com.mvcCrypto.mvcCrypto.controller;


import com.mvcCrypto.mvcCrypto.controller.service.CoinApiService;

import com.mvcCrypto.mvcCrypto.controller.service.CoinExternoService;
import com.mvcCrypto.mvcCrypto.controller.service.TransactionService;

import com.mvcCrypto.mvcCrypto.controller.service.UserCoinService;
import com.mvcCrypto.mvcCrypto.model.Transaction;
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
    model.addAttribute("movs",ts.getAll());
            return "AppView";
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return "AppView";
    }
    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute("transaction") Transaction tr, RedirectAttributes redirect){
        try{
            System.out.println(tr);
            tr.setType(true);
            tr.setId_user(1);
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

    @PostMapping("/withdraw")
    public String withdraw2(@ModelAttribute("balance") double balance,@ModelAttribute("id_coin") String id_coin,@ModelAttribute("id_user") long id_user, RedirectAttributes redirect){
        try{
         User_Coin uc = new User_Coin();
         Transaction tra=new Transaction();
            uc.setBalance(balance);
            uc.setId_user(id_user);
            uc.setId_coin(id_coin);
            tra.setType(true);
            tra.setDateTime(new Timestamp(System.currentTimeMillis()));
            tra.setBalance(balance);
            tra.setId_user(id_user);
            tra.setId_coin(id_coin);
            tra.setId_destination_user(id_user);

            ts.save(tra);
            ts.depositar(uc);
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


       /* @GetMapping("/{name}")
        public String findByName (Model model, @PathVariable("name") String name){

            model.addAttribute("coinName", ces.getByName(name));


            return "Index";
        }*/


}
