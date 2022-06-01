package com.apiCrypto.apiCrypto.controller;



import com.apiCrypto.apiCrypto.model.Coin;
import com.apiCrypto.apiCrypto.model.User_Coin;
import com.apiCrypto.apiCrypto.service.CoinService;
import com.apiCrypto.apiCrypto.service.User_CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/UserCoin")
public class User_CoinController {

    @Autowired
    private User_CoinService service;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<User_Coin> save(@RequestBody User_Coin u){
        User_Coin flag = service.save(u);
        if(flag ==null) return ResponseEntity.status(400).body(null);
        return ResponseEntity.status(201).body(flag);
    }
/*
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User_Coin coin){
        if(coin == null) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(201).body("Saved user_coin");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody User_Coin coin){
        if(coin == null || coin.getId_coin_userCoin().isEmpty()) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(200).body("Updated user_coin");
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(200).body("Deleted user_coin");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        User_Coin coin = service.getOne(id);
        return ResponseEntity.status(200).body(coin);
    }

    @GetMapping("/idUser/{id}")
    public ResponseEntity<Object> getAllByIdUser(@PathVariable("id") long id){
        ArrayList<User_Coin> coin = service.getAllByIdUser(id);
        return ResponseEntity.status(200).body(coin);
    }

}
