package app.service;

import app.model.Event;
import app.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event saveEvent(String userEmail, String description) {
        Event event = new Event();

        event.setId(UUID.randomUUID().toString());
        event.setUserEmail(userEmail);
        event.setDescription(description);

        return eventRepository.save(event);
    }

    public List<Event> resetPopulateEvents() {
        eventRepository.deleteAll();

        List<Event> eventList = new ArrayList<>();

        for (int i = 1; i <= 15; ++i) {
            Event event = new Event();
            event.setId("id" + i);
            event.setUserEmail("example" + i + "@example.com");
            event.setPublishDate(new Date());
            event.setDescription("Event " + i + " description");
            eventList.add(event);
        }

        return eventRepository.saveAll(eventList);
    }
}
