package com.rollerbladeRentApp.api.controller;

import com.rollerbladeRentApp.api.model.Customer;
import com.rollerbladeRentApp.api.model.NewCustomer;
import com.rollerbladeRentApp.api.model.UpdateCustomer;
import com.rollerbladeRentApp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    public final CustomerService customerService;

    @PostMapping
    public String registerCustomer(@ModelAttribute NewCustomer newCustomer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addCustomer";
        } else {
            customerService.registerCustomer(newCustomer);
            return "redirect:/customer";
        }
    }

    @GetMapping("/add")
    public ModelAndView displayAddCustomerPage() {
        ModelAndView modelAndView = new ModelAndView("/addSites/addCustomer");
        modelAndView.addObject("newCustomer", new NewCustomer());
        return modelAndView;
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

    @GetMapping
    public ModelAndView displayCustomersPage() {
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("customers", customerService.getAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public Customer getOneById(@PathVariable Long id) {
        return customerService.getById(id);
    }
}