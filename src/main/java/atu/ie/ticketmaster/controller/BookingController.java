package atu.ie.ticketmaster.controller;

import atu.ie.ticketmaster.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/buy")
    public String buyTickets(
            @RequestParam Long userId,
            @RequestParam Long eventId,
            @RequestParam int quantity) {

        bookingService.buyTickets(userId, eventId, quantity);
        return "Booking successful";
    }
}