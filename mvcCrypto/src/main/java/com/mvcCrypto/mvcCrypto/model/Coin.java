package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coin implements Serializable {

    private static final long serialVersionUID = 4676905652686424400L;

    private float ask;
    private float totalAsk;
    private float bid;
    private float totalBid;
    private Timestamp time;

  }


