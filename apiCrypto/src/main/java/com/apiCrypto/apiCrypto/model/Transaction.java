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
    @JoinColumn(name = "id_user")
    private User iduser;

   /* @ManyToOne
    @JoinColumn(name = "id_user_destination")
    private User id_user_destination;
*/
    @ManyToOne
    @JoinColumn(name = "id_coin")
    private Coin id_coin;

    private double price_in_transaction;

    private Timestamp date;

    private double balance;

    private boolean type;
}



