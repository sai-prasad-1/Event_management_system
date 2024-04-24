package io.levantate.eventmanagement.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long hallId;

    @Column(nullable = false)
    private int time;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private Date timestamp;

}
