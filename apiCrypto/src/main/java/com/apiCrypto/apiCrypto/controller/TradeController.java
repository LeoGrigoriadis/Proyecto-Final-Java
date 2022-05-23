package com.apiCrypto.apiCrypto.controller;



import java.util.List;

import javax.validation.Valid;

import com.apiCrypto.apiCrypto.model.Trade;
import com.apiCrypto.apiCrypto.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Trade")
public class TradeController {

    @Autowired
    private TradeService pS;

    @GetMapping
    public ResponseEntity<List<Trade>> getAll(){
        return ResponseEntity.status(200).body(pS.getAll());
    }
    
    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid Trade u) {
        Trade flag = pS.save(u);
        if (flag == null)
            return ResponseEntity.status(400).body("Error.");
           
        else
        return ResponseEntity.status(200).body("Success.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Trade p) {
        Trade pay = pS.update(p, p.getId_trade());
        if (pay == null) {
            
            return ResponseEntity.status(400).body("Incomplete data");

           

        } else
        pS.save(p);
        return ResponseEntity.status(200).body("Updated payment");
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
            pS.delete(id);
            return ResponseEntity.status(200).body("Deleted payment");
        }
    
}
