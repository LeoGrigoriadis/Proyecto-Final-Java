package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auth {

    @Email
    @NotEmpty(message = "El email es necesario.")
    private String gmail;
    @NotEmpty(message = "El password es necesario.")
    private String password;
    @NotBlank
    private Role id_role;
}

