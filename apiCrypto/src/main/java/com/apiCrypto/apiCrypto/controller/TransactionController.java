package com.apiCrypto.apiCrypto.controller;


import java.util.List;

import javax.validation.Valid;

import com.apiCrypto.apiCrypto.model.Transaction;
import com.apiCrypto.apiCrypto.model.User_Coin;
import com.apiCrypto.apiCrypto.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Transaction")
public class TransactionController {

  @Autowired TransactionService ts;

  @GetMapping
    public ResponseEntity<List<Transaction>> getAll() {
        return ResponseEntity.status(200).body(ts.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Transaction u) {
        boolean flag = ts.save(u);
        if (flag)
            return ResponseEntity.status(200).body("Success.");
        else
            return ResponseEntity.status(400).body("Error.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Transaction t) {
        boolean flag = ts.updateTransaction(t);
        if (flag) {
            ts.save(t);
            return ResponseEntity.status(200).body("Updated Transaction");

        } else
            return ResponseEntity.status(400).body("Incomplete data");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        ts.delete(id);
        return ResponseEntity.status(200).body("Deleted Transaction");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Transaction> getOne(@PathVariable("id") Long id){
        Transaction transaction = ts.getTransaction(id);
        return ResponseEntity.status(200).body(transaction);
    }
/*
    @PutMapping("/depositar/{balance}/{id_coin}/{id_user}")
    public ResponseEntity<String> depositar(@PathVariable("balance") double balance, @PathVariable("id_coin") String id_coin, @PathVariable("id_user") long id_user) {
    
        try{
            ts.depositar(balance, id_coin, id_user);
            return ResponseEntity.status(200).body("exito");  
        }catch(Exception e){
            return ResponseEntity.status(400).body(" fallido");
        }
        

    }
*/
    @PutMapping("/depositar/{balance}/{id_coin}/{id_user}")
    public ResponseEntity<String> Depositar(@RequestBody User_Coin uc) {

        try{
            ts.depositar(uc.getBalance(), uc.getId_coin().getId_coin(), uc.getId_user().getId_user());
            return ResponseEntity.status(200).body("exito");
        }catch(Exception e){
            return ResponseEntity.status(400).body(" fallido");
        }


    }


    @PutMapping("/cobrarMonto/{balance}/{id_coin}/{id_user}")
    public ResponseEntity<String> CobrarMonto(@PathVariable("balance") double balance, @PathVariable("id_coin") String id_coin, @PathVariable("id_user") long id_user) {
        
      
            
        
            try{
                ts.cobrarMonto(balance,id_coin,id_user);
            return ResponseEntity.status(200).body("Retiro exitoso");
            }catch(Exception e){
                return ResponseEntity.status(400).body("Retiro fallido");
            }

    }

    @PutMapping("/cobrarTodo/{id_coin}/{id_user}")
    public ResponseEntity<String> CobrarTodo(@PathVariable("id_coin") String id_coin, @PathVariable("id_user") long id_user) {
        try{
            ts.CobrarTodo(id_coin,id_user);
            return ResponseEntity.status(200).body("Retiro exitoso");
        }catch(Exception e){
            return ResponseEntity.status(400).body("Retiro fallido");
        }
    }

}
