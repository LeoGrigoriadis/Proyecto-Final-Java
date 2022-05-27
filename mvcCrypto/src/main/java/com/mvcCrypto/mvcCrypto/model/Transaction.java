package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    private long id_transaction;
    private User id_user;
  //  private User id_destination_user;
    private Coin id_coin;
    private double price_in_transaction;
    private Timestamp date;
    private double balance;
    private boolean type;
}


