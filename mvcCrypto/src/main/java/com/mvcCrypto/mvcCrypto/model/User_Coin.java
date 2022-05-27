package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User_Coin {
    
    private long id_account;
    private Coin id_coin_userCoin;
    private double balance;
    private User id_user_userCoin;
}


  