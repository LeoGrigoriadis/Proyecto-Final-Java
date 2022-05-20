package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    private int id_transaction;
    private int id_user;
    private int id_coin;
    private Date dateTime;
    private double balance;
    private boolean type;
}
