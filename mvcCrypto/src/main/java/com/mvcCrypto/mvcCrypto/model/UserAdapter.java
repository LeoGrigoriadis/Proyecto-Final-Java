package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAdapter {


        @NotEmpty(message = "El email es necesario.")
        private String gmail;
        @NotEmpty(message = "La fecha de nacimiento es necesario.")
        private Date birthday;
        @NotEmpty(message = "El nombre es necesario.")
        private String firstName;
        @NotEmpty(message = "El apellido es necesario.")
        private String lastName;
        @NotEmpty(message = "El password es necesario.")
        private String password;

}