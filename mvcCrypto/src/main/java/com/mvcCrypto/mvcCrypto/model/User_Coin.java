package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User_Coin {
    private int num_cuenta;
    private int id_coin;
    private double balance;
    private int id_user;
}
