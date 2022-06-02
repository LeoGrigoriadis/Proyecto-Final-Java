package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User_CoinAdapter {

    private long id_account;
    @NotNull(message = "El nombre es necesario.")
    private CoinAdapter id_coin;
    @NotEmpty(message = "El nombre es necesario.")
    private String id_coin_destino;
    @NotNull
    @Positive(message = "the balance has to be positive")
    private double balance;
    @NotNull
    private User id_user;
    @NotNull
    private long id_destino;
}
