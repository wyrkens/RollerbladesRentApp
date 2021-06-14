package com.rollerbladeRentApp.repository;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rollerblades")
@NoArgsConstructor
public class RollerbladesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rollerbladesId;
    private String status;
    private String brand;
    private String type;
    private int size;
    private int price;

}
