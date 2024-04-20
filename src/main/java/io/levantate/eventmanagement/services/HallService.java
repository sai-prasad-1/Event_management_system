package io.levantate.eventmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.levantate.eventmanagement.models.Hall;
import io.levantate.eventmanagement.repository.HallRepository;


@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;

    public Hall registerHall(Hall hall) {
        return hallRepository.save(hall);
    }
    public Hall updateHall(Hall hall) {
        return hallRepository.save(hall); 
    }

    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public Hall getHallById(Long id) {
        Optional<Hall> optionalHall = hallRepository.findById(id);
        return optionalHall.orElse(null);
    }
}
