package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> getbyIdUser(long id);

    List<Payment> getbyId_loan(long id_loan);

    void deleteById_loan(long id);
}