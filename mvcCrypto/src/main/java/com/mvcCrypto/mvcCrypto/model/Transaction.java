package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    private long id_transaction;
    private long id_user;
    private String id_coin;
    private Date dateTime;
    private double balance;
    private boolean type;
}
