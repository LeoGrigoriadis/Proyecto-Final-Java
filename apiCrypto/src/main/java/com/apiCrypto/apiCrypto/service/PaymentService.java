package com.apiCrypto.apiCrypto.service;

import com.apiCrypto.apiCrypto.repository.IPaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
 
    @Autowired
    private IPaymentRepository pR;
}
