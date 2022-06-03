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

        private String gmail;
        private Date birthday;
        private String firstName;
        private String lastName;
        private String password;

        public UserAdapter(String value){
                this.birthday= Date.valueOf(value);
        }
}