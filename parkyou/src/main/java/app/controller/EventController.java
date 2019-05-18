package app.controller;

import app.model.Event;
import app.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public Event saveEvent(@RequestParam(value = "userEmail") String userEmail,
                           @RequestParam(value = "description") String description) {
        return eventService.saveEvent(userEmail, description);
    }

    @PostMapping("/reset/populate")
    public List<Event> populateEvents() {
        return eventService.resetPopulateEvents();
    }
}
