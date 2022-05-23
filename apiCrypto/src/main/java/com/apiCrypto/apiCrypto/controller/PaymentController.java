package com.apiCrypto.apiCrypto.controller;



import java.util.List;

import javax.validation.Valid;

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
    
    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid Payment u) {
        boolean flag = pS.save(u);
        if (flag)
            return ResponseEntity.status(200).body("Success.");
        else
            return ResponseEntity.status(400).body("Error.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Payment p) {
        boolean pay = pS.updatePayment(p);
        if (pay) {
            pS.save(p);
            return ResponseEntity.status(200).body("Updated payment");

        } else
            return ResponseEntity.status(400).body("Incomplete data");

    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
            pS.delete(id);
            return ResponseEntity.status(200).body("Deleted payment");
        }
    
    
}
