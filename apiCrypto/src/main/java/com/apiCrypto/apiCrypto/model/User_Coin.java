package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User_Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_account;

    @OneToMany()
    @JoinColumn(name = "id_coin")
    private List<Coin> id_coin_userCoin;

    private double balance;

    @OneToMany()
    @JoinColumn(name = "id_user")
    private List<User> id_user_userCoin;
}
