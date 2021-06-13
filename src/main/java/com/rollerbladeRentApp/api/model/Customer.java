package com.rollerbladeRentApp.api.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long customerId;
    private String name;
    private String lastName;
    private String pesel;
    private String email;
    private String phoneNumber;
    private List<Loan> loanList;

}
