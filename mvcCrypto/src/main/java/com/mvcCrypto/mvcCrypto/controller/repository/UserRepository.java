package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class UserRepository {

    @Autowired
    private RestTemplate rt;
    public ArrayList<User> findAll(){
        String url = "http://localhost:8090/api/users";
             ArrayList<User> user = new ArrayList<>();
        user = rt.getForObject(url, ArrayList.class);

        return user;
    }

    public User getById(long id){
        String url = "http://localhost:8090/api/users/getOne"+id;
        User user;
        user = rt.getForObject(url, User.class);
        return user;
    }

    public void delete(long id) {
        String url = "http://localhost:8090/api/users/delete/" + id;
        rt.delete(url);
    }

    public void save(User es) {
        String url = "http://localhost:8090/api/users/save";
        rt.postForObject(url, es, User.class);
    }

    public void update(User es) {
        String url = "http://localhost:8090/api/users/update";
        rt.put(url, es, User.class);
    }

}
