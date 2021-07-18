package com.rollerbladeRentApp.service.mapper;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.Rent;
import com.rollerbladeRentApp.repository.customer.CustomerEntity;
import com.rollerbladeRentApp.repository.rent.RentEntity;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    public RentEntity modelToEntity(Rent rent) {

        CustomerMapper customerMapper = new CustomerMapper();
        CustomerEntity customerEntity = customerMapper.modelToEntity(rent.getCustomerId());

        return RentEntity.builder()
                .customer(customerEntity)
                .price(rent.getPrice())
                .loanTime(rent.getLoanTime())
                .returnTime(rent.getReturnTime())
                .build();
    }

    public Rent entityToModel(RentEntity rentEntity) {

        CustomerMapper customerMapper = new CustomerMapper();
        Customer customer = customerMapper.entityToModel(rentEntity.getCustomer());

        return Rent.builder()
                .customerId(customer)
                .price(rentEntity.getPrice())
                .loanTime(rentEntity.getLoanTime())
                .returnTime(rentEntity.getReturnTime())
                .build();
    }
}
