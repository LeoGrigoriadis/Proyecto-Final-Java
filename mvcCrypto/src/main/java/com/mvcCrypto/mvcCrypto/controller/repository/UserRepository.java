package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class UserRepository {
    public ArrayList<User> findAll(){
        String url = "http://localhost:8080/users";
        RestTemplate rt = new RestTemplate();
        ArrayList<User> user = new ArrayList<>();
        user = rt.getForObject(url, ArrayList.class);

        return user;
    }

    public User getByGmail(String gmail){
        String url = "http://localhost:8080/users/"+gmail;
        RestTemplate rt = new RestTemplate();
        User user;
        user = rt.getForObject(url, User.class);
        return user;
    }

    public void delete(long id) {
        String url = "http://localhost:8080/users/delete/" + id;
        RestTemplate rt = new RestTemplate();
        rt.delete(url);
    }

    public void save(User es) {
        String url = "http://localhost:8080/users/save";
        RestTemplate rt = new RestTemplate();
        rt.postForObject(url, es, User.class);
    }

}
