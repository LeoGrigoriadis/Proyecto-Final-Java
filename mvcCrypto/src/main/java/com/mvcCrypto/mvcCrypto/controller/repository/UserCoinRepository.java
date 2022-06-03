package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.User;
import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class UserCoinRepository{

    @Autowired
    private RestTemplate rt;

    public ArrayList<User_Coin> findAllByIdUser(long id){
        String url = "http://localhost:8090/api/UserCoin/idUser/{id}";
        ArrayList<User_Coin> user_coins= rt.getForObject(url,ArrayList.class, id);
        return user_coins;
    }

    public User_Coin findById(long id){
        String url = "http://localhost:8090/api/UserCoin/{id}";
        User_Coin user_coins= rt.getForObject(url,User_Coin.class, id);
        return user_coins;
    }
    public ArrayList<User_Coin> findAll(long id){
        String url = "http://localhost:8090/api/UserCoin/{id}";
        ArrayList<User_Coin> user= rt.getForObject(url, ArrayList.class, id);
        return user;
    }

    public void delete(long id) {
        String url = "http://localhost:8090/api/UserCoin/delete/{id}";
        rt.delete(url, id);
    }

    public void save(User_Coin es) {
        String url = "http://localhost:8090/api/UserCoin/save";
        rt.postForObject(url, es, User_Coin.class);
    }

    public User_Coin findByIdUserAndIdCoin(long idu, String idc) {
        String url = "http://localhost:8090/api/UserCoin/{idu}/{idc}";
        User_Coin usercoin= rt.getForObject(url, User_Coin.class, idu, idc);
        return usercoin;
    }
}
