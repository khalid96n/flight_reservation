package com.Flight_reserve.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_reserve.Entity.passenger;

public interface passengerRepository extends JpaRepository<passenger, Long> {

}
