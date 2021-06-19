package com.rollerbladeRentApp.repository.customer;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String lastName;
    private String pesel;
    private String email;
    private String phoneNumber;

}
