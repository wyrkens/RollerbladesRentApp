package com.rollerbladeRentApp.service.mapper;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.NewCustomer;
import com.rollerbladeRentApp.repository.customer.CustomerEntity;

public class CustomerMapper {

    public CustomerEntity entityToNewCustomer(NewCustomer newCustomer) {
        return CustomerEntity.builder()
                .name(newCustomer.getName())
                .lastName(newCustomer.getLastName())
                .pesel(newCustomer.getPesel())
                .email(newCustomer.getEmail())
                .phoneNumber(newCustomer.getPhoneNumber())
                .build();
    }

    public Customer customerToEntity(CustomerEntity customerEntity) {
        return Customer.builder()
                .customerId(customerEntity.getCustomerId())
                .name(customerEntity.getName())
                .lastName(customerEntity.getLastName())
                .pesel(customerEntity.getPesel())
                .email(customerEntity.getEmail())
                .phoneNumber(customerEntity.getPhoneNumber())
                .build();
    }
}
