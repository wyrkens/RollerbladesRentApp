package com.rollerbladeRentApp.service;

import com.rollerbladeRentApp.api.model.Rent;
import com.rollerbladeRentApp.repository.rent.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentService {

    private final RentRepository rentRepository;

    private void createRent(Rent rent){
        //rentRepository.save();
    }
}
