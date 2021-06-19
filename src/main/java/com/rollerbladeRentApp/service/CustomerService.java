package com.rollerbladeRentApp.service;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.NewCustomer;
import com.rollerbladeRentApp.api.model.UpdateCustomer;
import com.rollerbladeRentApp.repository.customer.CustomerEntity;
import com.rollerbladeRentApp.repository.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(NewCustomer newCustomer) {
        customerRepository.save(entityToNewCustomer(newCustomer));
    }

    @Transactional
    public void updateCustomer(UpdateCustomer updateCustomer) {
        CustomerEntity customerEntity = customerRepository.findById(updateCustomer.getCustomerId())
                .orElseThrow(() -> new IllegalStateException("Customer with id: " + updateCustomer.getCustomerId() + " doesn't exists"));
        customerEntity.setLastName(updateCustomer.getLastName());
        customerEntity.setEmail(updateCustomer.getEmail());
        customerEntity.setPhoneNumber(updateCustomer.getPhoneNumber());
        customerRepository.save(customerEntity);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll().stream()
                .map(this::customerToEntity)
                .collect(Collectors.toList());
    }

    public Customer getOneById(Long id) {
        return customerRepository.findById(id)
                .map(this::customerToEntity)
                .orElseThrow(() -> new IllegalStateException("Customer doesn't exists"));
    }

    private CustomerEntity entityToNewCustomer(NewCustomer newCustomer) {
        return CustomerEntity.builder()
                .name(newCustomer.getName())
                .lastName(newCustomer.getLastName())
                .pesel(newCustomer.getPesel())
                .email(newCustomer.getEmail())
                .phoneNumber(newCustomer.getPhoneNumber())
                .build();
    }

    private Customer customerToEntity(CustomerEntity customerEntity) {
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
