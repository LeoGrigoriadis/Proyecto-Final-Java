package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trade {

    private User id_user_trade;
    private long id_trade;
    private CoinAdapter id_initial_coin;
    private LocalDateTime date;
    private double balance;
    private double price_initial_coin;

}


