package com.apiCrypto.apiCrypto.service;

import java.util.List;

import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService  {

    @Autowired
    private IUserRepository uR;

  
    public List<User> getAll(){
        return uR.findAll();

    }

    public void insertUser(User u){
        if (uR.existsById(u.getId())){
            uR.save(u);
        }
    }

    public void deleteUser(long id){
        if(uR.existsById(id)) {
			uR.deleteById(id);
		}
    }

    
	public User getUser(long id) {
		return uR.getById(id);
	}
	
	public boolean updateUser(User u) {
		if(!uR.existsById(u.getId())) {
			return false;
		} else {
			uR.save(u);
			return true;			
		}	
	}
}
