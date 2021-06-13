package com.rollerbladeRentApp.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    private Long loanId;
    private Customer customer;
    private Employee employee;
    private Reservation reservation;

}
