package com.apiCrypto.apiCrypto.controller;


import java.util.List;

import javax.validation.Valid;

import com.apiCrypto.apiCrypto.model.Transaction;
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
    public ResponseEntity<Object> save(@RequestBody @Valid Transaction u) {
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

    @DeleteMapping("/dalete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        ts.delete(id);
        return ResponseEntity.status(200).body("Deleted Transaction");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Transaction> getOne(@PathVariable("id") Long id){
        Transaction transaction = ts.getTransaction(id);
        return ResponseEntity.status(200).body(transaction);
    }

    @PutMapping("/depositar/{balance}/{id_coin}/{id_user}")
    public ResponseEntity<String> depositar(@Param("balance") double balance, @Param("id_coin") String id_coin, @Param("id_user") long id_user) {
        boolean flag = ts.depositar(balance,id_coin,id_user);
        if (flag) {
            return ResponseEntity.status(200).body("Deposito exitoso");

        } else
            return ResponseEntity.status(400).body("Deposito fallido");

    }


    @PutMapping("/CobrarMonto/{balance}/{id_coin}/{id_user}")
    public ResponseEntity<String> CobrarMonto(@Param("balance") double balance, @Param("id_coin") String id_coin, @Param("id_user") long id_user) {
        boolean flag = ts.CobrarMonto(balance,id_coin,id_user);
        if (flag) {
            return ResponseEntity.status(200).body("Retiro exitoso");

        } else
            return ResponseEntity.status(400).body("Retiro fallido");

    }

    @PutMapping("/CobrarMonto/{id_coin}/{id_user}")
    public ResponseEntity<String> CobrarMonto(@Param("id_coin") String id_coin, @Param("id_user") long id_user) {
        boolean flag = ts.CobrarTodo(id_coin,id_user);
        if (flag) {
            return ResponseEntity.status(200).body("Retiro exitoso");

        } else
            return ResponseEntity.status(400).body("Retiro fallido");

    }
    
}
