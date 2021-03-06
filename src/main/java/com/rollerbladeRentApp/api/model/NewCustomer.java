package com.rollerbladeRentApp.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewCustomer {

    private String name;
    private String lastName;
    private String pesel;
    private String email;
    private String phoneNumber;

}
