package com.Flight_reserve.Service;

import com.Flight_reserve.Entity.Reservation;
import com.Flight_reserve.dto.ReservationRequest;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest reservation);
	
}
