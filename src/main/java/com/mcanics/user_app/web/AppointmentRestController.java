package com.mcanics.user_app.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcanics.user_app.data.models.Appointment;
import com.mcanics.user_app.service.AppointmentService;


@RestController
@RequestMapping("/api/mechanic/appointments")
public class AppointmentRestController {

    @Autowired
    private AppointmentService appointmentService;

    public AppointmentRestController() {
    }

    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /** GET request to return specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    /** GET request to return all appointments based on a date range and ordered by price **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Appointment> findByDateRangeSortedByPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate) {
        return appointmentService.findByDateRangeSortedByPrice(startDate, endDate);
    }

    /** POST request to add new appointments **/
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

    /** PUT request to update appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.update(appointmentId, appointment);
    }

    /** PATCH request to update status of an appointment **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PATCH, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment updateStatus(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.updateStatus(appointmentId, appointment);
    }

    /** DELETE request to delete specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Long appointmentId) {
        appointmentService.deleteById(appointmentId);
    }
}
