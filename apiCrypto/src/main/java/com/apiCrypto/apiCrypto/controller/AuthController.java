package com.apiCrypto.apiCrypto.controller;


import java.util.List;
import java.util.Optional;

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

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid Auth u) {
        boolean flag = as.save(u);
        if (flag)
            return ResponseEntity.status(200).body("Success.");
        else
            return ResponseEntity.status(400).body("Error.");
    }


    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Auth auth){
        boolean flag = as.updateAuth(auth, auth.getGmail());
        if(flag == false || auth.getGmail().isEmpty()) return ResponseEntity.status(400).body("Incomplete data") ;
        as.save(auth);
        return ResponseEntity.status(200).body("Updated auth");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        as.deleteAuth(id);
        return ResponseEntity.status(200).body("Deleted Auth");
    }

    @GetMapping("/find-by-role/{gmail}")
    public ResponseEntity<String> getRole(@PathVariable("gmail") String gmail) {
        return ResponseEntity.status(200).body(as.getRoleu(gmail));
    }
    @GetMapping("/find-by-gmail/{gmail}")
    public ResponseEntity<Optional<Auth>> getGmail(@PathVariable("gmail") String gmail) {
        return ResponseEntity.status(200).body(as.getAuth(gmail));
    }
    
}
