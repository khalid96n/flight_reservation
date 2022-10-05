package com.Flight_reserve.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_reserve.Entity.Reservation;

public interface reservationRepository extends JpaRepository<Reservation, Long> {

}
