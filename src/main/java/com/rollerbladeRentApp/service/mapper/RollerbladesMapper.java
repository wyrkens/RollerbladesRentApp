package com.rollerbladeRentApp.service.mapper;

import com.rollerbladeRentApp.api.model.NewRollerblades;
import com.rollerbladeRentApp.api.model.Rollerblades;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;
import org.springframework.stereotype.Component;

@Component
public class RollerbladesMapper {

    public RollerbladesEntity newModelToEntity(NewRollerblades newRollerblades) {
        return RollerbladesEntity.builder()
                .status(newRollerblades.getStatus())
                .brand(newRollerblades.getBrand())
                .type(newRollerblades.getType())
                .size(newRollerblades.getSize())
                .price(newRollerblades.getPrice())
                .build();
    }

    public Rollerblades entityToModel(RollerbladesEntity entity) {
        return Rollerblades.builder()
                .rollerbladesId(entity.getRollerbladesId())
                .status(entity.getStatus())
                .brand(entity.getBrand())
                .type(entity.getType())
                .size(entity.getSize())
                .price(entity.getPrice())
                .build();
    }

    public RollerbladesEntity modelToEntity(Rollerblades rollerblades) {
        return RollerbladesEntity.builder()
                .status(rollerblades.getStatus())
                .brand(rollerblades.getBrand())
                .type(rollerblades.getType())
                .size(rollerblades.getSize())
                .price(rollerblades.getPrice())
                .build();
    }
}
