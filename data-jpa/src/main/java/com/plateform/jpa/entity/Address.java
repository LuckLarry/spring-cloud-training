package com.plateform.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "phone",nullable = true,length = 11)
    private String phone;

    @Column(name = "zipcode",nullable = true,length = 6)
    private String zipcode;

    @Column(name = "address",nullable = true,length = 100)
    private String address;

    @OneToOne(mappedBy = "address",cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    private People people;
}
