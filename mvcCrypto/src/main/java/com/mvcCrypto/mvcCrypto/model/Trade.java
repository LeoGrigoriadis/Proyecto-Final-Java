package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class Trade {

    private int id_user;
    private int id_trade;
    private int id_initial;
    private Timestamp dateTime;
    private double balance;
    private int id_destination_coin;
}
