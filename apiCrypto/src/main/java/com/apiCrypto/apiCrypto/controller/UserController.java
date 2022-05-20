package com.apiCrypto.apiCrypto.controller;

import java.util.List;

import javax.validation.Valid;

import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(200).body(us.getAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid User u) {
        boolean flag = us.save(u);
        if (flag)
            return ResponseEntity.status(200).body("Success.");
        else
            return ResponseEntity.status(400).body("Error.");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody User user) {
        boolean users = us.updateUser(user);
        if (users) {
            us.save(user);
            return ResponseEntity.status(200).body("Updated user");

        } else
            return ResponseEntity.status(400).body("Incomplete data");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        us.deleteUser(id);
        return ResponseEntity.status(200).body("Deleted user");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id){
        User user = us.getUser(id);
        return ResponseEntity.status(200).body(user);
    }
}
