package com.psa.flight_reservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.flight_reservation.dto.ReservationRequest;
import com.psa.flight_reservation.entities.flight;
import com.psa.flight_reservation.entities.passenger;
import com.psa.flight_reservation.entities.reservation;
import com.psa.flight_reservation.repository.flightRepository;
import com.psa.flight_reservation.repository.passengerRepository;
import com.psa.flight_reservation.repository.reservationRepository;
import com.psa.flight_reservation.util.PDFgenerator;


@Service
public class ReservationServiceimpl implements ReservationService {
	
	@Autowired
	private passengerRepository passengerRepo;
	
	@Autowired
	private flightRepository flightRepo;
	
	@Autowired
	private reservationRepository reservationRepo;
	
	@Autowired
	private PDFgenerator pdfGenerator;
	
	@Override
	public reservation bookFlight(ReservationRequest reservation) {  //saving passenger,getting flight object and reservation details
		
		passenger psngr=new passenger();
		psngr.setFirstName(reservation.getFirstName());
		psngr.setLastName(reservation.getLastName());
		psngr.setMiddleName(reservation.getMiddleName());
		psngr.setEmail(reservation.getEmail());
		psngr.setPhone(reservation.getPhone());
		passengerRepo.save(psngr);
		
		//have to flight and passenger object in reservation
		//flight data already injected before and getting it by its id
		long flightId=reservation.getFlightId();
		Optional<flight> findById = flightRepo.findById(flightId);
		flight flight = findById.get();
		
		//Now psngr and flight will go into reservation table
		
		reservation res=new reservation();
		res.setFlight(flight);
		res.setPsngr(psngr);
		res.setCheckedIn(false);
		res.setNumberOfBags(0);
		reservationRepo.save(res);
		
		String filePath="C:\\Users\\lenovo\\Desktop\\sts V8.1\\flight_reservation\\tickets\\booking"+res.getId()+".pdf";
		pdfGenerator.generateItinerary(res, filePath);
		
		return res;
	}

}
