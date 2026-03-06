package atu.ie.ticketmaster.services;

import atu.ie.ticketmaster.model.Venue;
import atu.ie.ticketmaster.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;

    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }
}