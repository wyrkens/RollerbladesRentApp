package com.rollerbladeRentApp.api.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rent {

    private Long rentId;
    private Customer customer;
    private Rollerblades rollerblades;
    private int price;
    private LocalDate loanTime;
    private LocalDate returnTime;

}
