package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Trade;
import com.mvcCrypto.mvcCrypto.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class TradeRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Trade> findAll(){
        String url = "http://localhost:8090/api/Trade";
        ArrayList<Trade> trade = new ArrayList<>();
        trade = rt.getForObject(url, ArrayList.class);

        return trade;
    }


    public void delete(long id) {
        String url = "http://localhost:8090/api/Trade/delete/{var1}" ;
        rt.delete(url,id);
    }

    public void save(Trade es) {
        String url = "http://localhost:8090/api/Trade/save";
        rt.postForObject(url, es, Trade.class);
    }

    public void update(Trade es) {
        String url = "http://localhost:8090/api/Trade/update";
        rt.put(url, es, Trade.class);
    }
}
