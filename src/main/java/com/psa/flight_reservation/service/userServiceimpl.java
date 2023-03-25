package com.psa.flight_reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.flight_reservation.entities.user;
import com.psa.flight_reservation.repository.userRepository;

@Service
public class userServiceimpl implements userService {
	
	@Autowired
	userRepository userRepo;
	@Override
	public void saveReg(user user1) {
		userRepo.save(user1);

	}

}
