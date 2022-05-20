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
    public ResponseEntity<List<Coin>> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Coin coin){
        if(coin == null) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(201).body("Saved coin");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Coin coin){
        if(coin == null || coin.getId_coin().isEmpty()) return ResponseEntity.status(400).body("Incomplete data") ;
        service.save(coin);
        return ResponseEntity.status(200).body("Updated coin");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.status(200).body("Deleted coin");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getOne(@PathVariable("id") String id){
        Coin coin = service.getByIdCoin(id);
        return ResponseEntity.status(200).body(coin);
    }
}
