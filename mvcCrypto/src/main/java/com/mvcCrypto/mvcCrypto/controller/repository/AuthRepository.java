package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

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
        String url = "http://localhost:8090/api/Auth/delete/{var1}";
        rt.delete(url,id);
    }

    public void save(Auth es) {
        String url = "http://localhost:8090/api/Auth/save";
        rt.postForObject(url, es, Auth.class);
    }

    public void update(Auth es) {
        String url = "http://localhost:8090/api/Auth/update";
        rt.put(url, es, Auth.class);
    }

    public Optional<Auth> findByGmail(String gmail) {
        String url = "http://localhost:8090/api/Auth/find-by-gmail/{gmail}";
        return rt.getForObject(url, Optional.class, gmail);
    }

    public String getRole(String gmail) {
        String url = "http://localhost:8090/api/Auth/find-by-role/{gmail}";
        return rt.getForObject(url, String.class, gmail);
    }
}
