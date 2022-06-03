package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

    private long id_transaction;
    private User id_user;
    private CoinAdapter id_coin;
    private double price_in_transaction;
    private Timestamp date;
    private double balance;
    private boolean type;
}


