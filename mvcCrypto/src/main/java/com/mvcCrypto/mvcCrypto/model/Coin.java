package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Coin {
    private int asset_id;
    private String name;
    private int type_is_crypto;
    private String data_quote_start;
    private String data_quote_end;
    private String data_orderbook_start;
    private String data_orderbook_end;
    private String data_trade_start;
    private String data_trade_end;
    private String data_symbols_count;
    private String volume_1hrs_usd;
    private String volume_1day_usd;
    private double volume_1mth_usd;
    private double price_usd;
    private String id_icon;
    private String data_start;
    private String data_end;
}
