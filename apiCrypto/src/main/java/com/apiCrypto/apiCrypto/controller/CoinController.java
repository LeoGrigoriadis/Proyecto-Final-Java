package com.apiCrypto.apiCrypto.controller;

import com.apiCrypto.apiCrypto.model.Coin;
import com.apiCrypto.apiCrypto.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Coin")
public class CoinController {

    @Autowired
    private CoinService service;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Coin coin){
        boolean flag = service.save(coin);
        if(flag == false) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(201).body("Saved coin");
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Coin coin){
        
        if(coin == null || coin.getId_coin().isEmpty()) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(200).body("Updated coin");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.status(200).body("Deleted coin");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") String id){
        Coin coin = service.getByIdCoin(id);
        return ResponseEntity.status(200).body(coin);
    }
}
