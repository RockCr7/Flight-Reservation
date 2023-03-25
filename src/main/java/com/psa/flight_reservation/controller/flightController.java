package com.psa.flight_reservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.flight_reservation.entities.flight;
import com.psa.flight_reservation.repository.flightRepository;

@Controller
public class flightController {
	
	@Autowired
	private flightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,Model model) {
		List<flight> findFlights = flightRepo.findFlights(from,to,departureDate);
		model.addAttribute("findFlights", findFlights);
//		System.out.println(findFlights);
		return "displayFlights";
	}
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,Model model) {
//		System.out.println(flightId);
		Optional<flight> findById = flightRepo.findById(flightId);
		flight flight = findById.get();
		model.addAttribute("flight", flight);
		return "showReservation";
	}
}
