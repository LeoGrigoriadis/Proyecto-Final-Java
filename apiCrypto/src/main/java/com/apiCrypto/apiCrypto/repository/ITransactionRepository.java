package com.apiCrypto.apiCrypto.repository;

import java.util.List;

import com.apiCrypto.apiCrypto.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITransactionRepository extends JpaRepository<Transaction,Long>{
    
    @Query(value = "Select * from transaction t where t.id_user = :id", nativeQuery = true)
    public List<Transaction> getbyIdUser(@Param("id") long id);

   // @Query

}
