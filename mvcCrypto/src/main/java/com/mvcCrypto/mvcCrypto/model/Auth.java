package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auth {
    private String gmail;

    private String password;

    private Role id_role;
}

