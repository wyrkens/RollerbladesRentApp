package com.rollerbladeRentApp.repository.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String lastName;
    private String pesel;
    private String email;
    private String phoneNumber;

    public CustomerEntity updateCustomer(String newLastName, String newEmail, String newPhoneNumber) {
        this.lastName = newLastName;
        this.email = newEmail;
        this.phoneNumber = newPhoneNumber;
        return this;
    }

}
