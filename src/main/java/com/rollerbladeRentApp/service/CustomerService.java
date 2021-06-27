package com.rollerbladeRentApp.service;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.NewCustomer;
import com.rollerbladeRentApp.api.model.UpdateCustomer;
import com.rollerbladeRentApp.repository.customer.CustomerRepository;
import com.rollerbladeRentApp.service.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public void registerCustomer(NewCustomer newCustomer) {
        customerRepository.save(customerMapper.entityToNewCustomer(newCustomer));
    }

    @Transactional
    public void updateCustomer(UpdateCustomer updateCustomer) {
        customerRepository.findById(updateCustomer.getCustomerId())
                .map(cust -> cust.updateCustomer(updateCustomer.getLastName(), updateCustomer.getEmail(),
                        updateCustomer.getPhoneNumber()))
                .orElseThrow(() -> new IllegalStateException("Customer with id: " + updateCustomer.getCustomerId() + " doesn't exists."));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToEntity)
                .collect(Collectors.toList());
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToEntity)
                .orElseThrow(() -> new IllegalStateException("Customer with id: " + id + " doesn't exists."));
    }
}
