package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trade {

    private long id_user;
    private long id_trade;
    private long id_initial;
    private Timestamp dateTime;
    private double balance;
    private long id_destination_coin;
}
