package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

    private long id_loan;
    private long id_initial_user;
    private String id_coin;
    private Timestamp date;
    private double balance;
    private long id_destination_user;
}
