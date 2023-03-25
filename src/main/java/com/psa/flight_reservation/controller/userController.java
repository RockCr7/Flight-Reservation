package com.psa.flight_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.flight_reservation.entities.user;
import com.psa.flight_reservation.repository.userRepository;
import com.psa.flight_reservation.service.userService;

@Controller
public class userController {
	
	@Autowired
	userService userService;
	
	@Autowired
	userRepository userRepo;
	
	@RequestMapping("/showLoginPage")  //to directly access login-page without show-reg
	public String showLoginPage() {
		return "login/login";
	}

	
	
	
	//	http://localhost:8080/flights/showReg
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("x") user user1) {
		userService.saveReg(user1);
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId,@RequestParam("password") String password,Model model) {
		user user1 = userRepo.findByEmail(emailId); //returning object data from database in user1 consist email and password
		
		if(user1!=null) {
			if(user1.getEmail().equals(emailId) && user1.getPassword().equals(password)) {
				return "findFlights";
			}else {
				model.addAttribute("msg", "Invalid Email/Password");
				return "login/login";
			}
	}
		else {
			model.addAttribute("msg", "Invalid Email/Password");
			return "login/login";
		}
		
	}
}
