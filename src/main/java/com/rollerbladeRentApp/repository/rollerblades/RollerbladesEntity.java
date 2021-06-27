package com.rollerbladeRentApp.repository.rollerblades;

import com.rollerbladeRentApp.repository.rent.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "rollerblades")
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

    public RollerbladesEntity updateRollerblades(String status) {
        this.status = status;
        return this;
    }

}
