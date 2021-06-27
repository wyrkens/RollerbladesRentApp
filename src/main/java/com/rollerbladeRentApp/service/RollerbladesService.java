package com.rollerbladeRentApp.service;

import com.rollerbladeRentApp.api.model.NewRollerblades;
import com.rollerbladeRentApp.api.model.Rollerblades;
import com.rollerbladeRentApp.api.model.UpdateRollerblades;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesRepository;
import com.rollerbladeRentApp.service.mapper.RollerbladesMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RollerbladesService {

    private final RollerbladesRepository rollerbladesRepository;
    private final RollerbladesMapper rollerbladesMapper;

    public void createRollerblades(NewRollerblades newRollerblades) {
        rollerbladesRepository.save(rollerbladesMapper.entityToNewRollerblades(newRollerblades));
    }

    @Transactional
    public void updateRollerblades(UpdateRollerblades updateRollerblades) {
        RollerbladesEntity entity = rollerbladesRepository.findByRollerbladesId(updateRollerblades.getRollerbladesId())
                .map(roller -> roller.updateRollerblades(updateRollerblades.getStatus()))
                .orElseThrow(() -> new IllegalStateException("Rollerblades with id: " + updateRollerblades.getRollerbladesId() + " doesn't exists."));
    }

    public void deleteRollerblades(Long id) {
        rollerbladesRepository.deleteById(id);
    }

    public Rollerblades getById(Long id) {
        return rollerbladesRepository.findByRollerbladesId(id)
                .map(rollerbladesMapper::rollerbladesToEntity)
                .orElseThrow(() -> new IllegalStateException("Rollerblades with id: " + id + " doesn't exists."));
    }

    public List<Rollerblades> getAll() {
        return rollerbladesRepository.findAll().stream()
                .map(rollerbladesMapper::rollerbladesToEntity)
                .collect(Collectors.toList());
    }
}
