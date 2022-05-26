package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User_Coin {
    
    private long id_account;
    private String id_coin;
    private double balance;
    private long id_user;
}
