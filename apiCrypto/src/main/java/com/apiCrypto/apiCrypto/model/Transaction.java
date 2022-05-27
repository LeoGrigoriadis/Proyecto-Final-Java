package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_transaction;

    @ManyToOne
    private User id_user;
//puede tirar error
    @ManyToOne
    @JoinColumn(name = "id_user_destination")

    @ManyToOne

    private User id_destination_user;

    @ManyToOne
   
    private Coin id_coin;

    private double price_in_transaction;

    private Timestamp date;

    private double balance;

    private boolean type;

}



