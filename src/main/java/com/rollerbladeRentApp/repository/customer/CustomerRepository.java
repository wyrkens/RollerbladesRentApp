package com.rollerbladeRentApp.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAllByNameAndLastName(String name, String lastName);

    List<CustomerEntity> findAllByPesel(String pesel);

    List<CustomerEntity> findAllByPeselLike(String pesel);

    Long countAllByLastNameIgnoreCase(String lastName);

}
