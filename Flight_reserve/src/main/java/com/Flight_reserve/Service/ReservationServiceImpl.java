package com.Flight_reserve.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Flight_reserve.Entity.Flight;
import com.Flight_reserve.Entity.Reservation;
import com.Flight_reserve.Entity.passenger;
import com.Flight_reserve.Repository.flightRepository;
import com.Flight_reserve.Repository.passengerRepository;
import com.Flight_reserve.Repository.reservationRepository;
import com.Flight_reserve.Utilities.PDFGenerate;
import com.Flight_reserve.dto.ReservationRequest;

@Service
public class ReservationServiceImpl implements ReservationService{


	 String filePath= "e:\\tickets\\";
	
	
	@Autowired 
	private passengerRepository passengerRepo;
	
	@Autowired
	private flightRepository flightRepo;
	
	@Autowired
	private reservationRepository reserveRepo;
	
	@Override
	public Reservation bookFlight(ReservationRequest reservation) {

		passenger passenger = new passenger();
	
		passenger.setFirstName(reservation.getFirstName());
		passenger.setLastName(reservation.getLastName());
		passenger.setMiddleName(reservation.getMiddleName());
		passenger.setEmail(reservation.getEmail());
		passenger.setPhone(reservation.getPhone());
		passengerRepo.save(passenger);
		
		Long flightId = reservation.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);	
		Flight flight = findById.get();

		
		
		Reservation reserv =new Reservation();

		reserv.setFlight(flight);
		reserv.setPassenger(passenger);
		reserv.setCheckedIn(false);
		reserv.setNumberOfBags(0);
		reserveRepo.save(reserv);
		
		PDFGenerate pdf = new PDFGenerate();
		pdf.generatePDF(filePath+reserv.getId()+".pdf",reservation.getFirstName(),reservation.getEmail(), reservation.getPhone(), flight.getOperatingAirlines(), flight.getDepartureCity(), flight.getArrivalCity());
		
		return reserv;
		
	}

}
