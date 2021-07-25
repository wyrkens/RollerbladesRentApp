package com.rollerbladeRentApp.service;

import com.rollerbladeRentApp.api.model.Rent;
import com.rollerbladeRentApp.api.model.UpdateRent;
import com.rollerbladeRentApp.repository.rent.RentRepository;
import com.rollerbladeRentApp.service.mapper.RentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final RentMapper rentMapper;

    public void createRent(Rent rent) {
        rentRepository.save(rentMapper.modelToEntity(rent));
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
