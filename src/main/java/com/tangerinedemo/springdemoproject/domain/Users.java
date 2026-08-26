package com.tangerinedemo.springdemoproject.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "TG_USERS")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;


}
