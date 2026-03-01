package atu.ie.ticketmaster.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private double price;
    private int availableTickets;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
}
