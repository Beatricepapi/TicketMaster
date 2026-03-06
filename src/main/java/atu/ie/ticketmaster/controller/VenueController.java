package atu.ie.ticketmaster.controller;

import atu.ie.ticketmaster.model.Venue;
import atu.ie.ticketmaster.services.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @PostMapping
    public Venue addVenue(@RequestBody Venue venue) {
        return venueService.addVenue(venue);
    }
}
