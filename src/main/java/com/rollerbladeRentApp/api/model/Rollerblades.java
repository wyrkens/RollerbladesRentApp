package com.rollerbladeRentApp.api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rollerblades {

    private Long rollerbladesId;
    private String status;
    private String brand;
    private String type;
    private int size;
    private int price;

}
