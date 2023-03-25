package com.psa.flight_reservation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psa.flight_reservation.dto.ReservationUpdateRequest;
import com.psa.flight_reservation.entities.reservation;
import com.psa.flight_reservation.repository.reservationRepository;

@RestController
public class reservationRestController {
	
	@Autowired
	private reservationRepository reservationRepo;
	
	@RequestMapping("/reservation/{id}")
	public reservation findReservation(@PathVariable("id") long id) { 
		Optional<reservation> findById = reservationRepo.findById(id);
		reservation reservation = findById.get();
		return reservation;
	}
	
	@RequestMapping("/reservation")
	public reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<reservation> findById = reservationRepo.findById(request.getId());
		reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepo.save(reservation);
	}
}
