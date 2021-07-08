package com.rollerbladeRentApp.service.mapper;

import com.rollerbladeRentApp.api.model.Rent;
import com.rollerbladeRentApp.repository.rent.RentEntity;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    public RentEntity modelToEntity(Rent rent){
        return RentEntity.builder()
                .customer(rent.)
                .price(rent.getPrice())
                .loanTime(rent.getLoanTime())
                .returnTime(rent.getReturnTime())
                .build();
    }

    public Rent entityToModel(RentEntity rentEntity){
        return Rent.builder()
                .customerId(rentEntity.)
                .price(rentEntity.getPrice())
                .loanTime(rentEntity.getLoanTime())
                .returnTime(rentEntity.getReturnTime())
                .build();
    }
}
