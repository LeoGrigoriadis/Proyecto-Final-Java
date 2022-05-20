package com.apiCrypto.apiCrypto.repository;


import com.apiCrypto.apiCrypto.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {


    @Query(value = "Select * from transaction t where t.id_user = :id", nativeQuery = true)
    public List<Transaction> getbyIdUser(@Param("id") long id);

    List<Transaction> findAll();

    Transaction save(Transaction t);

    void deleteById(long id);

    //@Query(value = "", nativeQuery = true)

/*
    @Query(value = "from transaction t where t.id_user = :id")
    List<Transaction> findByIdUser(@Param(value = "id" ) long id);

    @Query(value = "from transaction  where t.id_user = ?1 and s.id = ?2")
    List<Transaction> findByIdUser(long id, long id_transaction);
*/






    /*List<Transaction> getbyIdUser(long id);
    *  Transaction makeTransaction();
    * */
}
