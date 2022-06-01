
package com.apiCrypto.apiCrypto.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apiCrypto.apiCrypto.model.Transaction;
import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.repository.IUserCoinRepository;
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

    public User save(User u) {
        try {
            User user =uR.save(u);
            return user;
        } catch (Exception e) {
            return null;
        }
    }


    public boolean deleteUser(long id) {
        if (uR.existsById(id)) {
            uR.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<User> getUser(long id) {
        return uR.findById(id);
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

    public Optional<User> getUserXgmail(String gmail){
        return uR.getByGmail(gmail);
    }
}