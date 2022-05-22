package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
 


   
}
