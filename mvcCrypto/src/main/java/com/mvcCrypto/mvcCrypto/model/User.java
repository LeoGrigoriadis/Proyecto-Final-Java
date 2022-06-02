package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


    private long id_user;
    @NotEmpty(message = "El nombre es necesario.")
    private String first_name;
    @NotEmpty(message = "El apellido es necesario.")
    private String last_name;
    @NotEmpty(message = "La fecha de nacimiento es necesario.")
    private Date birthday;
    /*
    private Account_type account_type;
    @NotBlank
    private int account_points;
    */
    @NotEmpty(message = "El email es necesario.")
    private Auth gmail;

}
