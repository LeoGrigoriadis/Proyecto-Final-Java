package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class Coin implements Serializable{
    private static final long serialVersionUID = 4676905652686424400L;
    private String asset_id;
    private String name;
    //private boolean type_is_crypto;
    //private String data_quote_start;
    //private String data_quote_end;
    //private String data_orderbook_start;
    //private String data_orderbook_end;
   // private String data_trade_start;
    //private String data_trade_end;
    //private int data_symbols_count;
   // private double volume_1hrs_usd;
    //private double volume_1day_usd;
    //private double volume_1mth_usd;
    private double price_usd;
    //private String id_icon;
    //private String data_start;
    //private String data_end;


    public String getAsset_id() {
        return asset_id;
    }
}


