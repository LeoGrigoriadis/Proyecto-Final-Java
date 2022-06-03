package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coin{


    private String name;
    private float ask;
    private float totalAsk;
    private float bid;
    private float totalBid;
    private Timestamp time;

  }


