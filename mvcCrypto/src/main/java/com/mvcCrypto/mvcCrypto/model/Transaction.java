package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int id_transaction;
    private int id_user;
    private int id_coin;
    private Date dateTime;
    private double balance;
    private boolean type;
}
