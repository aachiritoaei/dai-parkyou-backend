package app.controller;

import app.model.ParkingSpot;
import app.service.ParkingSpotService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking/spots")
public class ParkingSpotController {

    private ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping
    public List<ParkingSpot> getAllSpotsForUserEmail(@RequestParam("userEmail") String userEmail) {
        return parkingSpotService.listAllParkingSpotsForUserEmail(userEmail);
    }


}
