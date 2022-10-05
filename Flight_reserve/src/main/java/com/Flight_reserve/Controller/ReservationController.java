package com.Flight_reserve.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Flight_reserve.Entity.Reservation;
import com.Flight_reserve.Service.ReservationService;
import com.Flight_reserve.dto.ReservationRequest;


@Controller
public class ReservationController {

	@Autowired
	private ReservationService ReservationServ;
	
	@RequestMapping("/completeReservation")
	public String confirmReservation(ReservationRequest reservation,ModelMap model) {
		System.out.println(reservation.getFlightId());
		Reservation resrvationID = ReservationServ.bookFlight(reservation);
		model.addAttribute("resrvationID",resrvationID.getId());
		return "confirmReservation";
	}
	

}
