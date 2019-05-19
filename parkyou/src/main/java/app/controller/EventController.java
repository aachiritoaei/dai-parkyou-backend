package app.controller;

import app.model.Event;
import app.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
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
                           @RequestBody Map<String, String> requestBody) {
        return eventService.saveEvent(userEmail, requestBody.get("description"));
    }

    @PostMapping("/reset/populate")
    public List<Event> populateEvents() {
        return eventService.resetPopulateEvents();
    }
}
