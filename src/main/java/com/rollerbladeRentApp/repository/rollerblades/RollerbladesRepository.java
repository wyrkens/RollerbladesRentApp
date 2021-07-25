package com.rollerbladeRentApp.repository.rollerblades;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RollerbladesRepository extends JpaRepository<RollerbladesEntity, Long> {

    Optional<RollerbladesEntity> findByRollerbladesId(Long id);

    List<RollerbladesEntity> findAllByBrandAndType(String brand, String type);

    List<RollerbladesEntity> findAllByPrice(int price);

    List<RollerbladesEntity> findAllBySize(int size);

    List<RollerbladesEntity> findAllByStatusAndSize(String status, int size);

    List<RollerbladesEntity> findAllByRent_LoanTimeIsAfter(LocalDate loanAfterDate);

    List<RollerbladesEntity> findAllBySizeBetween(int minSize, int maxSize);


}
