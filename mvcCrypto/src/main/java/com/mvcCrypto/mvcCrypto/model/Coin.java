package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coin{
    @NotEmpty(message = "El nombre es necesario.")
    private String name;
    @NotBlank
    private float ask;
    @NotBlank
    private float totalAsk;
    @NotBlank
    private float bid;
    @NotBlank
    private float totalBid;
    @NotBlank
    private Timestamp time;

  }


