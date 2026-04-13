package atu.ie.ticketmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore   // 🔥 FIX: prevents infinite loop
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}