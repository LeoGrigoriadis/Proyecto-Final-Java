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
    private long id_user;
    private long id_destination_user;
    private String id_coin;
    private double price_in_transaction;
    private Timestamp dateTime;
    private double balance;
    private boolean type;
}
