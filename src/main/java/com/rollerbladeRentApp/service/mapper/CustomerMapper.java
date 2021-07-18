package com.rollerbladeRentApp.service.mapper;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.NewCustomer;
import com.rollerbladeRentApp.repository.customer.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity newModelToEntity(NewCustomer newCustomer) {
        return CustomerEntity.builder()
                .name(newCustomer.getName())
                .lastName(newCustomer.getLastName())
                .pesel(newCustomer.getPesel())
                .email(newCustomer.getEmail())
                .phoneNumber(newCustomer.getPhoneNumber())
                .build();
    }

    public NewCustomer entityToNewModel(CustomerEntity customerEntity) {
        return NewCustomer.builder()
                .name(customerEntity.getName())
                .lastName(customerEntity.getLastName())
                .pesel(customerEntity.getPesel())
                .email(customerEntity.getEmail())
                .phoneNumber(customerEntity.getPhoneNumber())
                .build();

    }

    public CustomerEntity modelToEntity(Customer customer) {
        return CustomerEntity.builder()
                .name(customer.getName())
                .lastName(customer.getLastName())
                .pesel(customer.getPesel())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    public Customer entityToModel(CustomerEntity customerEntity) {
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
