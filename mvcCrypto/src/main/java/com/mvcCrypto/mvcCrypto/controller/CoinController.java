package com.mvcCrypto.mvcCrypto.controller;

import com.mvcCrypto.mvcCrypto.controller.service.CoinService;
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
    private CoinService cs;

    @GetMapping("")
    public String getAll(Model model) {
        try {

            model.addAttribute("coins", cs.getAll());

            return "Index";
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return "Index";
    }


       /* @GetMapping("/{name}")
        public String findByName (Model model, @PathVariable("name") String name){

            model.addAttribute("coinName", cs.getByName(name));


            return "Index";
        }*/


}
