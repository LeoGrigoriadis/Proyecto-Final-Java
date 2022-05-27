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
    private Account_type account_type;
    private int account_points;
    private Auth gmail;

}
