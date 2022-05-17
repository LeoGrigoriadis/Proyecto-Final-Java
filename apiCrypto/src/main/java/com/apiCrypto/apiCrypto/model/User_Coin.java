package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User_Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nro_cuenta;
    
    @ManyToOne()
    @JoinColumn(name = "id_coin")
    private Coin id_coin;

    private double balance;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    private User id_user;
}
