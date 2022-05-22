package com.apiCrypto.apiCrypto.service;

import com.apiCrypto.apiCrypto.model.Payment;
import com.apiCrypto.apiCrypto.model.Transaction;
import com.apiCrypto.apiCrypto.repository.IPaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private IPaymentRepository payR;

    public List<Payment> getAll(){

        return payR.findAll();
    }

    public Payment save (Payment p){

        return payR.save(p);
    }

    public Payment getByIdloan( long id_loan){

        return payR.getById(id_loan);
    }

    public void delete(long id_loan) {
        if (payR.existsById(id_loan)) {
        payR.deleteById(id_loan);
        
        }
    }

     public boolean updatePayment(Payment p) {
        if (!payR.existsById(p.getId_loan())) {
            return false;
        } else {
            payR.save(p);
            return true;
        }
    }

}