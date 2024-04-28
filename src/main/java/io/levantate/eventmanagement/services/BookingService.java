package io.levantate.eventmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.levantate.eventmanagement.models.Booking;
import io.levantate.eventmanagement.repository.BookingRepository;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    

    public Booking registerBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        return optionalBooking.orElse(null);
    }
}
