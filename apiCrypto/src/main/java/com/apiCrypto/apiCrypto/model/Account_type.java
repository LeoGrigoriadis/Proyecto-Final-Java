package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_account_type;

    private  String overdrawn_turn_name;

    private int overdrawn_turn_value;

}
