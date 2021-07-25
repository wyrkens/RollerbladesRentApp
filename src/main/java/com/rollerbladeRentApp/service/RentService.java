package com.rollerbladeRentApp.service;

import com.rollerbladeRentApp.api.model.Rent;
import com.rollerbladeRentApp.api.model.UpdateRent;
import com.rollerbladeRentApp.repository.customer.CustomerEntity;
import com.rollerbladeRentApp.repository.customer.CustomerRepository;
import com.rollerbladeRentApp.repository.rent.RentEntity;
import com.rollerbladeRentApp.repository.rent.RentRepository;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesRepository;
import com.rollerbladeRentApp.service.mapper.RentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final RentMapper rentMapper;
    private final CustomerRepository customerRepository;
    private final RollerbladesRepository rollerbladesRepository;

    public void createRent(Rent rent) {
        RentEntity rentEntity = rentMapper.modelToEntity(rent);
        Optional<CustomerEntity> byId = customerRepository.findById(rent.getCustomer().getCustomerId());
        if (byId.isPresent()) {
            rentEntity.setCustomer(byId.get());
        } else {
            throw new IllegalStateException("Customer with id: " + rent.getCustomer().getCustomerId() + " doesn't exists.");
        }
        Optional<RollerbladesEntity> byIdR = rollerbladesRepository.findById(rent.getRollerblades().getRollerbladesId());
        if (byIdR.isPresent()) {
            rentEntity.setRollerblades(byIdR.get());
        } else {
            throw new IllegalStateException("Rollerblades with id: " + rent.getRollerblades().getRollerbladesId() + " doesn't exists.");
        }
        rentRepository.save(rentEntity);
    }

    @Transactional
    public void updateRent(UpdateRent updateRent) {
        rentRepository.findById(updateRent.getRentId())
                .map(rent -> rent.updateRent(updateRent.getPrice(), updateRent.getReturnTime()))
                .orElseThrow(() -> new IllegalStateException("Rent with id: " + updateRent.getRentId() + " doesn't exists."));
    }

    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }

    public Rent getById(Long id) {
        return rentRepository.findById(id)
                .map(rentMapper::entityToModel)
                .orElseThrow(() -> new IllegalStateException("Rent with id: " + id + " doesn't exists."));
    }

    public List<Rent> getAll() {
        return rentRepository.findAll().stream()
                .map(rentMapper::entityToModel)
                .collect(Collectors.toList());
    }
}
