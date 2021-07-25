package com.rollerbladeRentApp.repository.rent;

import com.rollerbladeRentApp.repository.customer.CustomerEntity;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rents")
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @JoinColumn(name = "customer_id")
    @ManyToOne(cascade = {CascadeType.ALL})
    private CustomerEntity customer;
    @JoinColumn(name = "rollerblades_id")
    @ManyToOne(cascade = {CascadeType.ALL})
    private RollerbladesEntity rollerblades;
    private int price;
    private LocalDate loanTime;
    private LocalDate returnTime;

    public RentEntity updateRent(int newPrice, LocalDate newReturnTime) {
        this.price = newPrice;
        this.returnTime = newReturnTime;
        return this;
    }
}
