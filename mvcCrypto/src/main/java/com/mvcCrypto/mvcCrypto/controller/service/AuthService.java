package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.AuthRepository;
import com.mvcCrypto.mvcCrypto.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private AuthRepository ar;

    public ArrayList<Auth> findAll(){
        return ar.findAll();
    }

    public  void delete(long id){
        ar.delete(id);
    }

    public void save(Auth auth){
        ar.save(auth);
    }

    public void update (Auth auth){
        ar.update(auth);
    }

    @Override
    public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
        Optional<Auth> optional = ar.findByGmail(gmail);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(gmail);
        }
        Auth u = optional.get();
        Set<GrantedAuthority> set = new HashSet<>();
        set.add(new SimpleGrantedAuthority(ar.getRole(gmail)));
        User user = new User(u.getGmail(), u.getPassword(), set);
        return user;
    }
}
