package io.levantate.eventmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.levantate.eventmanagement.models.Booking;


@Repository 
public interface BookingRepository extends JpaRepository<Booking, Long> {
  
}
