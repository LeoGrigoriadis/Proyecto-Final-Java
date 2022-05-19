package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Auth {

    @Id
    private String gmail;

    private String password;
    @OneToOne
    @JoinColumn(name = "id_role")
    private Role id_role;


}
