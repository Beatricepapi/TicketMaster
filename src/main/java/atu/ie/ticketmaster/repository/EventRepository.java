package atu.ie.ticketmaster.repository;

import atu.ie.ticketmaster.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
