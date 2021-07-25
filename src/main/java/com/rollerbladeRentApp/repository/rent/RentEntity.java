package com.rollerbladeRentApp.repository.rent;

import com.rollerbladeRentApp.repository.customer.CustomerEntity;
import com.rollerbladeRentApp.repository.rollerblades.RollerbladesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
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
    @ManyToOne
    private CustomerEntity customer;
    @JoinColumn(name = "rollerblades_id")
    @ManyToOne
    private RollerbladesEntity rollerblades;
    private int price;
    private LocalDateTime loanTime;
    private LocalDateTime returnTime;

    public RentEntity updateRent(int newPrice, LocalDateTime newReturnTime) {
        this.price = newPrice;
        this.returnTime = newReturnTime;
        return this;
    }
}
