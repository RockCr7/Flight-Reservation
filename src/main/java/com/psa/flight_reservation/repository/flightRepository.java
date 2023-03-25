package com.psa.flight_reservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psa.flight_reservation.entities.flight;

public interface flightRepository extends JpaRepository<flight, Long> {
	
	@Query("from flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")  //used when search operation is based on more than one parameter
	List<flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate); //there might be more than one record hence returning as list

}
