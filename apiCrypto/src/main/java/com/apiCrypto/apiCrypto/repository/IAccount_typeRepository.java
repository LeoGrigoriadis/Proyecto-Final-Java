package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.Account_type;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccount_typeRepository extends JpaRepository<Account_type,Long>{

    List<Account_type> getbyIdAccount_type(long id_account_type);

    void deleteByAccount_type(long id_account_type);
}
