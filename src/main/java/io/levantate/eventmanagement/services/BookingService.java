package io.levantate.eventmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.levantate.eventmanagement.models.Booking;
import io.levantate.eventmanagement.repository.BookingRepository;
import io.levantate.eventmanagement.repository.HallRepository;
import io.levantate.eventmanagement.repository.UserRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private UserRepository userRepository;

    

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
