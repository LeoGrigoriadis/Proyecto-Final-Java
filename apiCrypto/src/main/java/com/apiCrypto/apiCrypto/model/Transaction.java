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
    private long id_transaction;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_destination_user;

    @ManyToOne
    @JoinColumn(name = "id_coin")
    private Coin id_coin;



    private Timestamp date;

    private double balance;

    private boolean type;

}



