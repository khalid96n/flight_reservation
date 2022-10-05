package com.Flight_reserve.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_reserve.Entity.User;
import com.Flight_reserve.Repository.userRepository;

@Controller
public class UserController {

	
	@Autowired 
	private userRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
	
	
	
	@RequestMapping("/savereg")
	public String savereg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password,ModelMap model) {
	
	  User user = userRepo.findByEmail(emailId);
	  if (user!=null) {
		
	
		if (user.getEmail().equals(emailId)&& user.getPassword().equals(password)) {
			return "findFlights";	
		}else {
			model.addAttribute("error","invalid userid OR password");
			return "login/login";
		}
	  }
	  else {
			model.addAttribute("error","invalid userid OR password");
			return "login/login";
		
	}
		
			
	}
	
	
}
