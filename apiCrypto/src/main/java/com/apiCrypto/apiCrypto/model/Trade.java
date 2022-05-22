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
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_trade;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user_trade;

    @ManyToOne
    @JoinColumn(name = "id_coin")
    private Coin id_initial_coin;

    private Timestamp date ;

    private double balance;
/*
    @ManyToOne
    @JoinColumn(name = "id_coin")
    private Coin id_destination_coin;

*/
}
