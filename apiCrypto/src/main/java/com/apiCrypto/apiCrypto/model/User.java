package com.apiCrypto.apiCrypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"gmail"})
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    private String first_name;

    private String last_name;

    @ManyToOne
    @JoinColumn(name = "account_type")
    private Account_type account_type;

    private int account_points;

    @NotEmpty(message = "name required")
    @OneToOne
    @JoinColumn(name = "gmail")
    private Auth gmail;

   
}
