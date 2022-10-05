package com.Flight_reserve.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_reserve.Entity.User;

public interface userRepository extends JpaRepository<User, Long>{



	User findByEmail(String emailId);

}
