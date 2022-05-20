package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaction;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<User> id_user;

    @OneToMany
    @JoinColumn(name = "id_coin")
    private List<Coin> id_coin;

    private Timestamp date;

    private double balance;

    private boolean type;

}



