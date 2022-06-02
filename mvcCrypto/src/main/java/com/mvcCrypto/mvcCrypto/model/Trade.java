package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trade {
    @NotBlank
    private User id_user_trade;

    private long id_trade;
    @NotBlank
    private CoinAdapter id_initial_coin;
    @NotEmpty(message = "La fecha es necesaria.")
    private LocalDateTime date;
    @NotBlank
    @Positive(message = "the balance has to be positive")
    private double balance;
    @NotEmpty(message = "El precio es necesario.")
    private double price_initial_coin;

}


