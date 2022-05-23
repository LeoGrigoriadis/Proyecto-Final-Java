package com.apiCrypto.apiCrypto.controller;


import java.util.List;

import javax.validation.Valid;

import com.apiCrypto.apiCrypto.model.Auth;
import com.apiCrypto.apiCrypto.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Auth")
public class AuthController {

    @Autowired
    private AuthService as;
 
    @GetMapping
    public ResponseEntity<List<Auth>> getAll() {
        return ResponseEntity.status(200).body(as.getAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Auth u) {
        boolean flag = as.save(u);
        if (flag)
            return ResponseEntity.status(200).body("Success.");
        else
            return ResponseEntity.status(400).body("Error.");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Auth user) {
        boolean users = as.updateAuth(user);
        if (users) {
            as.save(user);
            return ResponseEntity.status(200).body("Updated Auth");

        } else
            return ResponseEntity.status(400).body("Incomplete data");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        as.deleteAuth(id);
        return ResponseEntity.status(200).body("Deleted Auth");
    }

    
}
