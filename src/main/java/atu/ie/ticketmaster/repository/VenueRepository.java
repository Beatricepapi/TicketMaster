package atu.ie.ticketmaster.repository;

import atu.ie.ticketmaster.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
