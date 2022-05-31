package com.apiCrypto.apiCrypto.repository;


import com.apiCrypto.apiCrypto.model.Transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {


    @Query(value = "Select * from (select * from transaction t order by t.date desc) t where t.id_user = :id", nativeQuery = true)
    public List<Transaction> getByIdUser(@Param("id") long id);

    List<Transaction> findAllByIduser(long iduser, Pageable pageable);

    List<Transaction> findAll();

    @Modifying
    @Transactional
    @Query(value="UPDATE user_coin SET user_coin.balance = user_coin.balance + :balance WHERE  user_coin.id_coin= :id_coin AND user_coin.id_user= :id_user", nativeQuery=true)
    public void Deposito(@Param("balance") double balance,@Param("id_coin") String id_coin, @Param("id_user") long id_user);

    @Modifying
    @Transactional
    @Query(value ="UPDATE user_coin SET user_coin.balance = user_coin.balance - :balance WHERE  user_coin.id_coin= :id_coin AND user_coin.id_user= :id_user", nativeQuery=true)
    public void CobrarMonto(@Param("balance") double balance, @Param("id_coin") String id_coin, @Param("id_user") long id_user);

    @Modifying
    @Transactional
    @Query(value="UPDATE user_coin SET user_coin.balance = user_coin.balance - user_coin.balance WHERE  user_coin.id_coin= :id_coin AND user_coin.id_user= :id_user", nativeQuery=true)
    public void CobrarTodo(@Param("id_coin") String id_coin, @Param("id_user") long id_user);

    @Query(value = "Select * from (select * from transaction t order by t.date desc limit 6) t where t.id_user = :id", nativeQuery = true)
    List<Transaction> getLastByUser(@Param("id") long id);
}
