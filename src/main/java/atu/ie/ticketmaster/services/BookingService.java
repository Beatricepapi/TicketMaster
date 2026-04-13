package atu.ie.ticketmaster.services;

import atu.ie.ticketmaster.model.Booking;
import atu.ie.ticketmaster.model.Event;
import atu.ie.ticketmaster.model.User;
import atu.ie.ticketmaster.repository.BookingRepository;
import atu.ie.ticketmaster.repository.EventRepository;
import atu.ie.ticketmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public Booking buyTickets(Long userId, Long eventId, int quantity) {

        System.out.println("UserId: " + userId);
        System.out.println("EventId: " + eventId);
        System.out.println("Quantity: " + quantity);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));

        System.out.println("Available tickets: " + event.getAvailableTickets());

        if (event.getAvailableTickets() < quantity) {
            throw new RuntimeException("Not enough tickets available");
        }

        event.setAvailableTickets(event.getAvailableTickets() - quantity);
        eventRepository.save(event);

        double totalPrice = event.getPrice() * quantity;

        Booking booking = Booking.builder()
                .user(user)
                .event(event)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findByUser(user);
    }
}