package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User_Coin {
    
    private long id_account;
    //@NotBlank
    private CoinAdapter id_coin;
    //@NotBlank
    //@Positive(message = "the balance has to be positive")
    private double balance;
    //@NotBlank
    private User id_user;
}



