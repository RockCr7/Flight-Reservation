package com.psa.flight_reservation.service;

import com.psa.flight_reservation.dto.ReservationRequest;
import com.psa.flight_reservation.entities.reservation;

public interface ReservationService {
	reservation bookFlight(ReservationRequest reservation);
}
