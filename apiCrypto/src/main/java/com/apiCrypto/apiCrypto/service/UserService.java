
package com.apiCrypto.apiCrypto.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository uR;

    public List<User> getAll() {
        return uR.findAll();
    }

    public boolean save(User u) {
    
        uR.save(u); 

        if(u==null){
            return false;
        }
        return true;    
    }


    public boolean deleteUser(long id) {
        if (uR.existsById(id)) {
            uR.deleteById(id);
            return true;
        }
        return false;
    }

    public User getUser(long id) {
        return uR.getById(id);
    }

    @Transactional
    public boolean update(User c, long id) {
        if (uR.getById(id) != null) {
            c.setId_user(id);
            uR.save(c);
            return true;
        } else {
            return false;
        }

    }
}