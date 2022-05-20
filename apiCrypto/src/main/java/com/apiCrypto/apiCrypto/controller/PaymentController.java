package com.apiCrypto.apiCrypto.controller;



import java.util.List;

import com.apiCrypto.apiCrypto.model.Payment;
import com.apiCrypto.apiCrypto.service.PaymentService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService pS;

    @GetMapping
    public ResponseEntity<List<Payment>> getAll(){
        return ResponseEntity.status(200).body(pS.getAll());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Payment p){
        if(p == null) return ResponseEntity.status(400).body("Incomplete data") ;
        pS.save(p);
        return ResponseEntity.status(201).body("Saved payment");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Payment p) {
        boolean pay = pS.updatePayment(p);
        if (pay) {
            pS.save(p);
            return ResponseEntity.status(200).body("Updated user");

        } else
            return ResponseEntity.status(400).body("Incomplete data");

    }
}
