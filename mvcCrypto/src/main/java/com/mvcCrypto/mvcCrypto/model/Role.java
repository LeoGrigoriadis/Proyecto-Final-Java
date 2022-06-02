package com.mvcCrypto.mvcCrypto.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    private long id_role;
    @NotEmpty(message = "El nombre es necesario.")
    private String name;
}
