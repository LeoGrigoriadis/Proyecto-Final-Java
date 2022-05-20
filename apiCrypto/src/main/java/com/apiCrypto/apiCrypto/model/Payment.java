package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_loan;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_initial_user;

    @ManyToOne
    @JoinColumn(name = "id_coin")
    private Coin id_coin;

    private Timestamp date;

    private double balance;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_destination_user;
}
