package com.rollerbladeRentApp.api.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rent {

    private Long reservationId;
    private Customer customerId;
    private Rollerblades rollerbladesId;
    private int price;
    private LocalDate loanTime;
    private LocalDate returnTime;

}
