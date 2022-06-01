package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    private long id_transaction;
    @NotBlank
    private User id_user;
    @NotBlank
    private CoinAdapter id_coin;
    @NotBlank
    private double price_in_transaction;
    @NotBlank
    private Timestamp date;
    @NotBlank
    @Positive(message = "the balance has to be positive")
    private double balance;
    @NotBlank
    private boolean type;
}


