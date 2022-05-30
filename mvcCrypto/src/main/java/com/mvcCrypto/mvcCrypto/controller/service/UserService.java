package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.UserRepository;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository uR;

    public void save(User user)
    {
        uR.save(user);
    }

    public void update(User user)
    {
        uR.update(user);
    }

    //GET ALL
    public ArrayList<User> getAll()
    {
        return (ArrayList<User>) uR.findAll();
    }

    //GET BY ID
    public User getById(long id)
    {
        return uR.getById(id);
    }

    //DELETE
    public void delete(long id) {
        uR.delete(id);
    }

    public String getGmailActualSesion(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String gmail = "";
        if (principal instanceof UserDetails) {
            gmail =  ((UserDetails) principal).getUsername();
        }
        return gmail;
    }
}
