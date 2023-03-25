package com.psa.flight_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.flight_reservation.entities.user;

public interface userRepository extends JpaRepository<user,Long> {

	user findByEmail(String emailId);  //no need to complete the method
                                     //spring boot will automatically searches for the email in database
}                                    //with the help of JpA-repository 
