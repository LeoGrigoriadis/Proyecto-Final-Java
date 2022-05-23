package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private long id_user;
    private String first_name;
    private String last_name;
    private int overdrawn_turn;
    private String user_type;
    private String gmail;

}
