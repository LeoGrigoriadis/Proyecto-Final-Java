package com.apiCrypto.apiCrypto.repository;
import com.apiCrypto.apiCrypto.model.User_Coin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IUserCoinRepository extends JpaRepository<User_Coin,Long>{
    

    List<User_Coin> findById(long id);

    @Query(value = "Select * from User_Coin where id_user = :id", nativeQuery = true)
    public ArrayList<User_Coin> findByUserId(@Param("id") long id);

    @Query(value = "Select * from User_Coin where id_user = :idu and id_coin=:idc", nativeQuery = true)
    User_Coin getByIdUserAndIdCoin(@Param("idu") Long idu,@Param("idc") String idc);
}
