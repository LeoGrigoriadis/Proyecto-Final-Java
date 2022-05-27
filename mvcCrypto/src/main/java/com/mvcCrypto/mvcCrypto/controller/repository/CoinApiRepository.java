package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.CoinAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class CoinApiRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<CoinAdapter> findAll() {
        String url = "http://localhost:8090/api/Coin";

        ArrayList<CoinAdapter> coins = new ArrayList<>();
        coins = rt.getForObject(url, ArrayList.class);
        return coins;
    }

    public CoinAdapter getOne(String id){
        String url = "http://localhost:8090/api/Coin/"+id;

        CoinAdapter user;
        user = rt.getForObject(url, CoinAdapter.class);
        return user;
    }

    public void delete(String id) {
        String url = "http://localhost:8080/api/Coin/" + id;

        rt.delete(url);
    }

    public void save(CoinAdapter es) {
        String url = "http://localhost:8080/api/Coin";

        rt.postForObject(url, es, Coin.class);
    }

}
