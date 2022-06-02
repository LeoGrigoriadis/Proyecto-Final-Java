package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoinAdapter {
    //@NotEmpty(message = "Seleccione la moneda")
    private String id_coin;
    //@NotEmpty(message = "El nombre es necesario.")
    private String name;


}

