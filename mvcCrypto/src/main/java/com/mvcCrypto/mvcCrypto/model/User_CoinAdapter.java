package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User_CoinAdapter {

    private long id_account;
    private CoinAdapter id_coin;
    private String id_coin_destino;
    private double balance;
    private User id_user;
    private long id_destino;
}
