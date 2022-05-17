package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITradeRepository extends JpaRepository<Trade, Long> {

    @Query(value = "SELECT * FROM Trade WHERE id_user = :id_user", nativeQuery = true)
        public List<Trade> getByIdUser(@Param("id_user") long id);
}
