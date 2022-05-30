package com.apiCrypto.apiCrypto.controller;

import java.util.List;
import java.util.Optional;


import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.service.UserService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Users")
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(200).body(us.getAll());
    }


     @PostMapping
    public ResponseEntity<Object> save(@RequestBody User u){
        boolean flag = us.save(u);
        if(flag ==false) return ResponseEntity.status(400).body("Incomplete data") ;
        us.save(u);
        return ResponseEntity.status(201).body("Saved user");
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
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        User user = us.getUser(id);
        return ResponseEntity.status(200).body(us.getUser(id));

    }

    @GetMapping("/find-by-gmail/{gmail}")
    public ResponseEntity<Optional<User>>  getByGmail(@PathVariable("gmail") String gmail){
        return ResponseEntity.status(200).body(us.getUserXgmail(gmail));
    }
}
