package com.apiCrypto.apiCrypto.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apiCrypto.apiCrypto.model.Account_type;
import com.apiCrypto.apiCrypto.repository.IAccount_typeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class Account_typeService {

    @Autowired
    private IAccount_typeRepository accr;

    public List<Account_type> getAll() {
        return accr.findAll();
    }

    public Account_type save(Account_type account) {

        return accr.save(account);
    }

    @Transactional
    public Account_type update(Account_type account) {
        if (accr.getById(account.getId_account_type()) != null) {
            account.setId_account_type(account.getId_account_type());
            return accr.save(account);
        } else {
            return null;
        }

    }

    public boolean delete(long id) {
        try {
            accr.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

    }

    public Account_type getByIdAccount_type(long id) {
        return accr.getById(id);
    }

}