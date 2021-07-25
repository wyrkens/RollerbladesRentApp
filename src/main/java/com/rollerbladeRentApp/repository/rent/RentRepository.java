package com.rollerbladeRentApp.repository.rent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentRepository extends JpaRepository<RentEntity, Long> {

    List<RentEntity> findAllByCustomer_Pesel(String pesel);

    Long countAllByRollerblades_Size(int size);

    Long countAllByRollerblades_Brand(String brand);

    List<RentEntity> findAllByLoanTimeAfter(LocalDate loanTimeAfter);

}
