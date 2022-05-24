package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trade {

    private long id_user;
    private long id_trade;
    private long id_initial;
    private double price_initial_coin;
    private LocalDateTime dateTime;
    private double balance;
    private long id_destination_coin;
    private double price_destination_coin;
}
