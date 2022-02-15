package com.mcanics.user_app.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcanics.user_app.data.models.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate startDate, LocalDate endDate);

	
}
