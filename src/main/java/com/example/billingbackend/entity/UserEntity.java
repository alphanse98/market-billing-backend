package com.example.billingbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotEmpty
    @Column(nullable = false)
    private String businessID;

    @NotEmpty
    @Column(nullable = false)
    private String role;

    @NotEmpty
    @Column(nullable = false,unique = true)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;
}
