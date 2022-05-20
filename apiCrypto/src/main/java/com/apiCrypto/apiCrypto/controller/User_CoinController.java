package com.apiCrypto.apiCrypto.controller;



import com.apiCrypto.apiCrypto.model.Coin;
import com.apiCrypto.apiCrypto.model.User_Coin;
import com.apiCrypto.apiCrypto.service.CoinService;
import com.apiCrypto.apiCrypto.service.User_CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/UserCoin")
public class User_CoinController {

    @Autowired
    private User_CoinService service;

    @GetMapping
    public ResponseEntity<List<User_Coin>> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody User_Coin coin){
        if(coin == null) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(201).body("Saved user_coin");
    }

    /*@PutMapping
    public ResponseEntity<String> update(@RequestBody User_Coin coin){
        if(coin == null || coin.getId_coin_userCoin().isEmpty()) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(200).body("Updated user_coin");
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(200).body("Deleted game");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_Coin> getOne(@PathVariable("id") Long id){
        User_Coin coin = service.getOne(id);
        return ResponseEntity.status(200).body(coin);
    }

    @GetMapping("/idUser/{id}")
    public ResponseEntity<User_Coin> getOneIdUser(@PathVariable("id") long id){
        User_Coin coin = service.getOneIdUser(id);
        return ResponseEntity.status(200).body(coin);
    }

}
