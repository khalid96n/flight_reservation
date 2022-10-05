package com.Flight_reserve.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_reserve.Entity.Flight;
import com.Flight_reserve.Repository.flightRepository;

@Controller
public class FlightController {
	

	@Autowired
	private flightRepository flightRepo;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,ModelMap model) 
	{
		
		List<Flight> findFlight= flightRepo.findFlights(from,to,departureDate);
			model.addAttribute("findFlight",findFlight);
			
		return "displayFlights";
	}
	
	@RequestMapping("/ShowCompleteReservation")
	public String ShowCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap model) {
		Optional<Flight> byId = flightRepo.findById(flightId);
		Flight flight = byId.get();
		model.addAttribute("flight",flight);
		return "ShowReservation";
	}
}