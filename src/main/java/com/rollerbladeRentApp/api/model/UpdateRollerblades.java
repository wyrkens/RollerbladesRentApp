package com.rollerbladeRentApp.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRollerblades {

    private Long rollerbladesId;
    private String status;
    private int price;

}
