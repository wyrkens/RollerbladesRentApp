package com.rollerbladeRentApp.service.mapper;

import com.rollerbladeRentApp.api.model.NewRollerblades;
import com.rollerbladeRentApp.api.model.Rollerblades;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;

public class RollerbladesMapper {

    public RollerbladesEntity entityToNewRollerblades(NewRollerblades newRollerblades) {
        return RollerbladesEntity.builder()
                .status(newRollerblades.getStatus())
                .brand(newRollerblades.getBrand())
                .type(newRollerblades.getType())
                .size(newRollerblades.getSize())
                .price(newRollerblades.getPrice())
                .build();
    }

    public Rollerblades rollerbladesToEntity(RollerbladesEntity entity) {
        return Rollerblades.builder()
                .rollerbladesId(entity.getRollerbladesId())
                .status(entity.getStatus())
                .brand(entity.getBrand())
                .type(entity.getType())
                .size(entity.getSize())
                .price(entity.getPrice())
                .build();
    }
}
