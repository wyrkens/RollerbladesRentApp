package com.rollerbladeRentApp.api.controller;

import com.rollerbladeRentApp.api.model.Rent;
import com.rollerbladeRentApp.api.model.UpdateRent;
import com.rollerbladeRentApp.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rents")
@AllArgsConstructor
public class RentController {

    public final RentService rentService;

    @PostMapping
    public ResponseEntity registerRent(@RequestBody Rent rent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body(
                    bindingResult.getAllErrors().stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
                            .collect(Collectors.toList()));
        } else {
            rentService.createRent(rent);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRent(@RequestBody UpdateRent updateRent) {
        rentService.updateRent(updateRent);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRent(@PathVariable Long id) {
        rentService.deleteRent(id);
    }

    @GetMapping("/{id}")
    public Rent getRentById(@PathVariable Long id) {
        return rentService.getById(id);
    }

    @GetMapping
    public List<Rent> getAllRent() {
        return rentService.getAll();
    }
}
