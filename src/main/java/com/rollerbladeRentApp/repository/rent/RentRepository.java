package com.rollerbladeRentApp.repository.rent;

import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RentRepository extends JpaRepository<RentEntity, Long> {

    Optional<RentEntity> findByRentId(Long id);

    List<RentEntity> findAllByCustomer_Pesel(String pesel);

    Long countAllByRollerblades_Size(int size);

    Long countAllByRollerblades_Brand(String brand);

    List<RentEntity> findAllByLoanTimeAfter(LocalDate loanTimeAfter);

}
