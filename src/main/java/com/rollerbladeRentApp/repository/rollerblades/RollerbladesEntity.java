package com.rollerbladeRentApp.repository.rollerblades;

import com.rollerbladeRentApp.repository.rent.RentEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
    @OneToMany(mappedBy = "rollerblades")
    private Set<RentEntity> rent;

}
