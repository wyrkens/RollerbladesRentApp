package com.rollerbladeRentApp.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewRollerblades {

    private Long rollerbladesId;
    private String status;
    private String brand;
    private String type;
    private int size;
    private int price;

}
