package com.rollerbladeRentApp.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomer {

    private Long customerId;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;

}
