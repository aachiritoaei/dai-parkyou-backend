package app.service;

import app.model.Event;
import app.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> populateEvents() {
        List<Event> eventList = new ArrayList<>();

        for (int i = 1; i <= 100; ++i) {
            Event event = new Event();
            event.setId("id" + i);
            event.setUserEmail("example" + i + "@example.com");
            event.setPublishDate(new Date());
            eventList.add(event);
        }

        return eventRepository.saveAll(eventList);
    }
}
