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
    private long id;

    private String first_name;

    private String last_name;
    @NotEmpty(message = "name required")
    private String gmail;

}
