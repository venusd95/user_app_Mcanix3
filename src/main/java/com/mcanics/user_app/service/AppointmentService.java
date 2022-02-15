package com.mcanics.user_app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.mcanics.user_app.data.models.Appointment;

public interface AppointmentService {

    Optional<Appointment> findById(Long appointmentId);

    List<Appointment> findAll();

    List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate);

    Appointment create(Appointment appointment);

    Appointment update(Long appointmentId, Appointment appointment);

    Appointment updateStatus(Long appointmentId, Appointment appointment);

    void deleteById(Long appointmentId);

}
