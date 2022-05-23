package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account_type {

    private long id_account_type;

    private  String overdrawn_turn_name;

    private int overdrawn_turn_value;
}
