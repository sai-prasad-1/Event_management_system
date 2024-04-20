package io.levantate.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.levantate.eventmanagement.models.Hall;
import io.levantate.eventmanagement.services.HallService;

import java.util.List;

public class HallController {
    @Autowired
    HallService hallService=new HallService();

    
     @PostMapping("/hall") // add hall
    public ResponseEntity<Object> registerHall(@RequestBody Hall hall) {
        try {
            Hall registeredHall = hallService.registerHall(hall);
            return ResponseEntity.ok(registeredHall);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register hall: " + e.getMessage());
        }
    }

    @PutMapping("/hall/") // update ha;;
    public ResponseEntity<Object> updateHall( @RequestBody Hall hall) {
        try {
            Hall updatedHall = hallService.updateHall(hall);
            return ResponseEntity.ok(updatedHall);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update hall: " + e.getMessage());
        }
    }


     @DeleteMapping("/hall/{id}") // dwlete a certain hal;l
    public ResponseEntity<Object> deleteHall(@PathVariable Long id) {
        try {
            hallService.deleteHall(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete hall: " + e.getMessage());
        }
    }

    @GetMapping("/hall") // get all halls
    public ResponseEntity<Object> getAllHalls() {
        try {
            List<Hall> halls = hallService.getAllHalls();
            return ResponseEntity.ok(halls);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch halls: " + e.getMessage());
        }
    }

    @GetMapping("/hall/{id}") // get a single hall details
    public ResponseEntity<Object> getHallById(@PathVariable Long id) {
        try {
            Hall hall = hallService.getHallById(id);
            if (hall != null) {
                return ResponseEntity.ok(hall);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch hall: " + e.getMessage());
        }
    }
}
