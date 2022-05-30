package com.apiCrypto.apiCrypto.controller;


import java.util.List;

import javax.validation.Valid;

import com.apiCrypto.apiCrypto.model.Account_type;
import com.apiCrypto.apiCrypto.service.Account_typeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Account")
public class Account_typeController {

    @Autowired
    private Account_typeService accS;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(200).body(accS.getAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Account_type u) {
        boolean flag = accS.save(u);
        if (flag)
            return ResponseEntity.status(200).body("Success.");
        else
            return ResponseEntity.status(400).body("Error.");
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Account_type a){
        if(a == null ) return ResponseEntity.status(400).body("Incomplete data") ;
        accS.save(a);
        return ResponseEntity.status(200).body("Updated Account");
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
            accS.delete(id);
            return ResponseEntity.status(200).body("Deleted Account");
        }

}
