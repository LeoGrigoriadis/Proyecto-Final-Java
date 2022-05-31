package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


    private long id_user;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;
    @NotBlank
    private Account_type account_type;
    @NotBlank
    private int account_points;

    @NotBlank
    private Auth gmail;

}
