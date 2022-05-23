package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Payment;
import com.mvcCrypto.mvcCrypto.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class PaymentRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Payment> findAll(){
        String url = "http://localhost:8090/api/Payment";
        ArrayList<Payment> payment = new ArrayList<>();
        payment = rt.getForObject(url, ArrayList.class);

        return payment;
    }


    public void delete(long id) {
        String url = "http://localhost:8090/api/Payment/delete/" + id;
        rt.delete(url);
    }

    public void save(Payment es) {
        String url = "http://localhost:8090/api/Payment/save";
        rt.postForObject(url, es, Payment.class);
    }

    public void update(Payment es) {
        String url = "http://localhost:8090/api/Payment/update";
        rt.put(url, es, Payment.class);
    }
}
