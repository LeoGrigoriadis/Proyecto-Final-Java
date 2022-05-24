package com.mvcCrypto.mvcCrypto.controller;


import com.mvcCrypto.mvcCrypto.controller.service.CoinApiService;

import com.mvcCrypto.mvcCrypto.controller.service.CoinExternoService;
import com.mvcCrypto.mvcCrypto.controller.service.TransactionService;
import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.CoinAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("")
public class CoinController {

    @Autowired
    private CoinExternoService ces;
    @Autowired
    private CoinApiService cas;
    @Autowired
    private TransactionService ts;


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
    model.addAttribute("movs",ts.getAll());
            return "AppView";
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return "AppView";
    }


       /* @GetMapping("/{name}")
        public String findByName (Model model, @PathVariable("name") String name){

            model.addAttribute("coinName", ces.getByName(name));


            return "Index";
        }*/


}
