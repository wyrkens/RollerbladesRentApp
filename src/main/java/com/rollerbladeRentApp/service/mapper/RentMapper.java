package com.rollerbladeRentApp.service.mapper;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.Rent;
import com.rollerbladeRentApp.api.model.Rollerblades;
import com.rollerbladeRentApp.repository.customer.CustomerEntity;
import com.rollerbladeRentApp.repository.rent.RentEntity;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    public RentEntity modelToEntity(Rent rent) {

        CustomerMapper customerMapper = new CustomerMapper();
        CustomerEntity customerEntity = customerMapper.modelToEntity(rent.getCustomer());

        RollerbladesMapper rollerbladesMapper = new RollerbladesMapper();
        RollerbladesEntity rollerbladesEntity = rollerbladesMapper.modelToEntity(rent.getRollerblades());

        return RentEntity.builder()
                .customer(customerEntity)
                .rollerblades(rollerbladesEntity)
                .price(rent.getPrice())
                .loanTime(rent.getLoanTime())
                .returnTime(rent.getReturnTime())
                .build();
    }

    public Rent entityToModel(RentEntity rentEntity) {

        CustomerMapper customerMapper = new CustomerMapper();
        Customer customer = customerMapper.entityToModel(rentEntity.getCustomer());

        RollerbladesMapper rollerbladesMapper = new RollerbladesMapper();
        Rollerblades rollerblades = rollerbladesMapper.entityToModel(rentEntity.getRollerblades());

        return Rent.builder()
                .customer(customer)
                .rollerblades(rollerblades)
                .price(rentEntity.getPrice())
                .loanTime(rentEntity.getLoanTime())
                .returnTime(rentEntity.getReturnTime())
                .build();
    }
}
