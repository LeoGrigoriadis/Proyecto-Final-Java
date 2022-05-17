package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaction;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user;

    @OneToOne
    @JoinColumn(name = "id_coin")
    private Coin id_coin;

    private Date dateTime;

    private double balance;

    private boolean type;
}



