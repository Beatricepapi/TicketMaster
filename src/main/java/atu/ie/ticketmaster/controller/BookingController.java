package atu.ie.ticketmaster.controller;

import atu.ie.ticketmaster.model.Booking;
import atu.ie.ticketmaster.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/buy")
    public Booking buyTickets(
            @RequestParam Long userId,
            @RequestParam Long eventId,
            @RequestParam int quantity) {

        return bookingService.buyTickets(userId, eventId, quantity);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable Long userId) {
        return bookingService.getUserBookings(userId);
    }
}