package com.rollerbladeRentApp.api.controller;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.NewCustomer;
import com.rollerbladeRentApp.api.model.UpdateCustomer;
import com.rollerbladeRentApp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    public final CustomerService customerService;

    @PostMapping
    public ResponseEntity registerCustomer(@RequestBody NewCustomer newCustomer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body(
                    bindingResult.getAllErrors().stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
                            .collect(Collectors.toList()));
        } else {
            customerService.registerCustomer(newCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody UpdateCustomer updateCustomer) {
        customerService.updateCustomer(updateCustomer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getOneById(@PathVariable Long id) {
        return customerService.getById(id);
    }
}