package com.apiCrypto.apiCrypto.service;

import com.apiCrypto.apiCrypto.model.Payment;
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

    public boolean save(Payment u) {
        try {
            if (payR.existsById(u.getId_loan())) {
                payR.save(u);

            }
            return true;
        } catch (Exception e) {
            return false;
        }
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