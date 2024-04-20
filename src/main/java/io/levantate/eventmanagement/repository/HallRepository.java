package io.levantate.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.levantate.eventmanagement.models.Hall;

@Repository 
public interface HallRepository extends JpaRepository<Hall, Long> {
    
    
}
