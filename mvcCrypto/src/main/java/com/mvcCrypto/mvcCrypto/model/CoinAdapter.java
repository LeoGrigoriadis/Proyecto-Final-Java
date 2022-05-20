package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CoinAdapter {
    private String id_coin;
    private String name;

    public String getId_coin() {
        return id_coin;
    }

    public String getName() {
        return name;
    }
}
