package com.apiCrypto.apiCrypto.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.apiCrypto.apiCrypto.model.Transaction;
import com.apiCrypto.apiCrypto.model.User_Coin;
import com.apiCrypto.apiCrypto.reportes.TransactionPdfReport;
import com.apiCrypto.apiCrypto.service.TransactionService;
import com.lowagie.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Transaction")
public class TransactionController {

  @Autowired TransactionService ts;


    @GetMapping("/{id}/{num}/{size}")
    public ResponseEntity<List<Transaction>> getPage(@PathVariable long id, @PathVariable int num, @PathVariable int size) {
        return ResponseEntity.status(200).body(ts.getByUser(id, num, size));

    }
    @GetMapping("/last/{id}")
    public ResponseEntity<List<Transaction>> getLast(@PathVariable long id) {
        return ResponseEntity.status(200).body(ts.getLastByUser(id));
    }

  @GetMapping("/{id}")
  public ResponseEntity<List<Transaction>> getAll(@PathVariable long id) {
      return ResponseEntity.status(200).body(ts.getByUser(id));
  }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Transaction u) {
        Transaction flag = ts.save(u);
        if (flag!=null)
        return ResponseEntity.status(200).body(flag);
        else
            return ResponseEntity.status(400).body("Error.");
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Transaction t) {
        boolean flag = ts.updateTransaction(t);
        if (flag) {
            ts.save(t);
            return ResponseEntity.status(200).body("Updated Transaction");

        } else
            return ResponseEntity.status(400).body("Incomplete data");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        ts.delete(id);
        return ResponseEntity.status(200).body("Deleted Transaction");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
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
    public ResponseEntity<Object> Depositar(@PathVariable("balance") double balance, @PathVariable("id_coin") String id_coin, @PathVariable("id_user") long id_user) {

        try{
            ts.depositar(balance,id_coin,id_user);
            return ResponseEntity.status(200).body("exito");
        }catch(Exception e){
            return ResponseEntity.status(400).body(" fallido");
        }


    }


    @PutMapping("/cobrarMonto/{balance}/{id_coin}/{id_user}")
    public ResponseEntity<Object> CobrarMonto(@PathVariable("balance") double balance, @PathVariable("id_coin") String id_coin, @PathVariable("id_user") long id_user) {

        try{
            ts.cobrarMonto(balance,id_coin,id_user);

         return ResponseEntity.status(200).body(true);
         }catch(Exception e){
             return ResponseEntity.status(400).body("Retiro fallido");
         }

 }

    @PutMapping("/cobrarTodo/{id_coin}/{id_user}")
    public ResponseEntity<Object> CobrarTodo(@PathVariable("id_coin") String id_coin, @PathVariable("id_user") long id_user) {
        try{
            ts.CobrarTodo(id_coin,id_user);
            return ResponseEntity.status(200).body("Retiro exitoso");
        }catch(Exception e){
            return ResponseEntity.status(400).body("Retiro fallido");
        }
    }

    @GetMapping("/find-All-by-idUser/{id_user}")
    public ResponseEntity<List<Transaction>> getByUserTransaction(@PathVariable("id_user") Long id){
        return ResponseEntity.status(200).body(ts.getByUser(id));
    }

    @GetMapping("/TransactionReport/pdf/{id_user}")
	public void reporteTransactionPDFbyUser(HttpServletResponse response, @PathVariable("id_user") long id) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment;filename=Transaction-ListPDF.pdf");
		TransactionPdfReport pdf = new TransactionPdfReport(ts.getByUser(id));
		pdf.export(response);
	} 
}
