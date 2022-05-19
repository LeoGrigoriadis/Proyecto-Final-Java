package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id_user;
    private String first_name;
    private String last_name;
    private int overdrawn_turn;
    private String user_type;
    private String gmail;

}
