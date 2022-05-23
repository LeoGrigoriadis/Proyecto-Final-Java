package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.PaymentRepository;
import com.mvcCrypto.mvcCrypto.model.Payment;
import com.mvcCrypto.mvcCrypto.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository pr;


    public ArrayList<Payment> findAll(){
        return pr.findAll();
    }

    public  void delete(long id){
        pr.delete(id);
    }

    public void save(Payment payment){
        pr.save(payment);
    }

    public void update (Payment payment){
        pr.update(payment);
    }
}
