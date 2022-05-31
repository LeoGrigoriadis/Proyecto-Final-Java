package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account_type {

    private long id_account_type;
    @NotBlank
    private  String overdrawn_turn_name;
    @NotBlank
    private int overdrawn_turn_value;
}
