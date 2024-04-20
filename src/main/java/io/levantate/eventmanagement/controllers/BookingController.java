package io.levantate.eventmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.levantate.eventmanagement.models.Booking;
import io.levantate.eventmanagement.services.BookingService;

public class BookingController {
    @Autowired
    BookingService bookingService=new BookingService();

    @PostMapping("/booking") // add hall
    public ResponseEntity<Object> registerBooking(@RequestBody Booking booking) {
        try {
            Booking registeredbooking = bookingService.registerBooking(booking);
            return ResponseEntity.ok(registeredbooking);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register booking: " + e.getMessage());
        }
    }

    @DeleteMapping("/booking/{id}") // dwlete a certain hal;l
    public ResponseEntity<Object> deletebooking(@PathVariable Long id) {
        try {
            bookingService.deleteBooking(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete booking: " + e.getMessage());
        }
    }

    @GetMapping("/booking") // get all halls
    public ResponseEntity<Object> getAllBookings() {
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch bookings: " + e.getMessage());
        }
    }

    @GetMapping("/booking/{id}") // get a single hall details
    public ResponseEntity<Object> getBookingById(@PathVariable Long id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            if (booking != null) {
                return ResponseEntity.ok(booking);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch booking: " + e.getMessage());
        }
    }
}
