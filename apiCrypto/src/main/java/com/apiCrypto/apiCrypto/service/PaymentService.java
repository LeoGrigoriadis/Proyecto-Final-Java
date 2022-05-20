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
    private IPaymentRepository pR;

    public List<Payment> getAll(){

        return pR.findAll();
    }

    public Payment save (Payment p){

        return pR.save(p);
    }

    public List <Payment> getById_loan( long id_loan){

        return pR.getbyId_loan(id_loan);
    }

    public void delete(long id_loan) {
        pR.deleteById_loan(id_loan);
    }

}