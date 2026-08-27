package com.tangerinedemo.springdemoproject.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TG_CACHE")
@Data
public class Cache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TG_KEY")
    private String key;

    @Column(name = "TG_VALUE")
    private String value;


}
