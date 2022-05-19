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
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_trade;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<User> id_user_trade;

    @OneToMany
    @JoinColumn(name = "id_coin")
    private List<Coin> id_initial_coin;

    private Timestamp date ;

    private double balance;
/*
    @ManyToOne
    @JoinColumn(name = "id_coin")
    private Coin id_destination_coin;

*/
}
