package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


    private long id_user;
    private String first_name;
    private String last_name;
    private Date birthday;
    private Auth gmail;

}
