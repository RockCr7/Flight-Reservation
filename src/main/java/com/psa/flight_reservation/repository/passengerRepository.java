package com.psa.flight_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.flight_reservation.entities.passenger;

public interface passengerRepository extends JpaRepository<passenger, Long> {

}
