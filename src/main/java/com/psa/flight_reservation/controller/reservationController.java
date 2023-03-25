package com.psa.flight_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psa.flight_reservation.dto.ReservationRequest;
import com.psa.flight_reservation.entities.reservation;
import com.psa.flight_reservation.service.ReservationService;

@Controller
public class reservationController {
	
	@Autowired   //class up-casting,automatically will create object of reservationserviceimpl class
	ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request,Model model) { //we can use request-param but the code will be lengthy
		//System.out.println(request.getFlightId());                service layer to save passenger,flight data and all in reservation table
		reservation resId = reservationService.bookFlight(request);
		model.addAttribute("resId", resId);
		return "confirmReservation";
	}
}
