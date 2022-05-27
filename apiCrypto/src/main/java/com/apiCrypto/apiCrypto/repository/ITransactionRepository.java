package com.apiCrypto.apiCrypto.repository;


import com.apiCrypto.apiCrypto.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {


    @Query(value = "Select * from transaction t where t.id_user = :id", nativeQuery = true)
    public List<Transaction> getbyIdUser(@Param("id") long id);

    List<Transaction> findAll();

    @Modifying
    @Transactional
    @Query(value="UPDATE user_coin SET user_coin.balance = user_coin.balance + :balance WHERE  user_coin.id_coin= :id_coin AND user_coin.id_user= :id_user", nativeQuery=true)
    public void Deposito(@Param("balance") double balance,@Param("id_coin") String id_coin, @Param("id_user") long id_user);

    @Modifying
    @Transactional
    @Query(value ="UPDATE user_coin SET user_coin.balance = user_coin.balance - :balance WHERE  user_coin.id_coin= :id_coin AND user_coin.id_user= :id_user", nativeQuery=true)
    public void CobrarMonto(@Param("balance") double balance,@Param("id_coin") String id_coin, @Param("id_user") long id_user);

    @Modifying
    @Transactional
    @Query(value="UPDATE user_coin SET user_coin.balance = user_coin.balance - user_coin.balance WHERE  user_coin.id_coin= :id_coin AND user_coin.id_user= :id_user", nativeQuery=true)
    public void CobrarTodo(@Param("id_coin") String id_coin, @Param("id_user") long id_user);

    /*@Query(value="UPDATE user_coin SET user_coin.balance = user_coin.balance + :balance WHERE  user_coin.id_coin= :id_coin AND user_coin.id_user= :id_user", nativeQuery=true)
    public  updateDeposito*/
    

    //@Query(value = "", nativeQuery = true)

/*
    @Query(value = "from transaction t where t.id_user = :id")
    List<Transaction> findByIdUser(@Param(value = "id" ) long id);

    @Query(value = "from transaction  where t.id_user = ?1 and s.id = ?2")
    List<Transaction> findByIdUser(long id, long id_transaction);
*/

    /*List<Transaction> getbyIdUser(long id);
    *  Transaction makeTransaction();
    *
    *
    *
    *
    * aplicacion
    *
    *
    *
    *
    *
    * */
}
