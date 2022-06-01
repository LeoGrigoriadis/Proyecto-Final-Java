package com.apiCrypto.apiCrypto.controller;

import java.util.List;
import java.util.Optional;

import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.model.User_Coin;
import com.apiCrypto.apiCrypto.service.UserService;

import com.apiCrypto.apiCrypto.service.User_CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Users")
public class UserController {

    @Autowired
    private UserService us;
    @Autowired
    private User_CoinService ucs;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(200).body(us.getAll());
    }

     @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User u){
        User flag = us.save(u);
        if(flag!=null) return ResponseEntity.status(201).body(flag);
        return ResponseEntity.status(400).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody User user) {
        boolean users = us.update(user, user.getId_user());
        if (users == false) return ResponseEntity.status(400).body("Incomplete data");
            us.save(user);
            return ResponseEntity.status(200).body("Updated user");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
       boolean flag = us.deleteUser(id);
       if(flag ==false)return ResponseEntity.status(400).body("Usuario no encontrado");
        return ResponseEntity.status(200).body("Deleted user");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Optional<User>> getOne(@PathVariable("id") Long id){
        return ResponseEntity.status(200).body(us.getUser(id));
    }

    @GetMapping("/find-by-gmail/{gmail}")
    public ResponseEntity<Optional<User>>  getByGmail(@PathVariable("gmail") String gmail){
        return ResponseEntity.status(200).body(us.getUserXgmail(gmail));
    }
}