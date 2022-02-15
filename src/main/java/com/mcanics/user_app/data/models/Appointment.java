package com.mcanics.user_app.data.models;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Data
@Entity
public class Appointment {

    private @Id @GeneratedValue Long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private LocalDate appointmentDate;
    private Time appointmentStartTime;
    private Time appointmentEndTime;
    private String nameOfMechanic;
    private AppointmentStatus status = AppointmentStatus.Booked;
    private BigDecimal price;

    public Appointment() {

    }

    public Appointment(Timestamp createdAt, LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime, String nameOfMechanic, AppointmentStatus status, BigDecimal price) {
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.nameOfMechanic = nameOfMechanic;
        this.status = status;
        this.price = price;
    }

    public Appointment(LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime, String nameOfMechanic, BigDecimal price) {
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.nameOfMechanic = nameOfMechanic;
        this.price = price;
    }

    public Appointment(LocalDate appointmentDate, String nameOfMechanic, BigDecimal price) {
        this.appointmentDate = appointmentDate;
        this.nameOfMechanic = nameOfMechanic;
        this.price = price;
    }

    }
