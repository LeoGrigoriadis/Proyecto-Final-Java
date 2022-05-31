package com.mvcCrypto.mvcCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAdapter {


        @NotEmpty
        private String gmail;
        @NotEmpty
        private Date birthday;
        @NotEmpty
        private String firstName;
        @NotEmpty
        private String lastName;
        @NotEmpty
        private String password;

}