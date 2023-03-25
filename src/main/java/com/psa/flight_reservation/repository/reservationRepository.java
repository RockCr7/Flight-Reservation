package com.psa.flight_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.flight_reservation.entities.reservation;

public interface reservationRepository extends JpaRepository<reservation, Long> {

}
