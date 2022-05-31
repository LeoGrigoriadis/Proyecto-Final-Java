package com.mvcCrypto.mvcCrypto.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    private long id_role;
    @NotBlank
    private String name;
}
