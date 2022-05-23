package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class AuthRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Auth> findAll(){
        String url = "http://localhost:8090/api/Auth";
        ArrayList<Auth> auth = new ArrayList<>();
        auth = rt.getForObject(url, ArrayList.class);

        return auth;
    }


    public void delete(long id) {
        String url = "http://localhost:8090/api/Auth/delete/" + id;
        rt.delete(url);
    }

    public void save(Auth es) {
        String url = "http://localhost:8090/api/Auth/save";
        rt.postForObject(url, es, Auth.class);
    }

    public void update(Auth es) {
        String url = "http://localhost:8090/api/Auth/update";
        rt.put(url, es, Auth.class);
    }
}
