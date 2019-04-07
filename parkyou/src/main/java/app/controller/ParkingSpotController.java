package app.controller;

import app.model.ParkingSpot;
import app.service.ParkingSpotService;
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
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotService.getAllParkingSpots();
    }

    @GetMapping("/{id}")
    public ParkingSpot getParkingSpot(@PathVariable("id") Integer parkingSpotId) {
        return parkingSpotService.getParkingSpotById(parkingSpotId);
    }

    @GetMapping("/user")
    public ParkingSpot getParkingSpotByEmail(@RequestParam("userEmail") String userEmail) {
        return parkingSpotService.getParkingSpotByUserEmail(userEmail);
    }

    @GetMapping("/free")
    public List<ParkingSpot> getParkingSpotByEmail() {
        return parkingSpotService.getAllFreeParkingSpots();
    }

    @PostMapping("/{id}")
    public ParkingSpot reserveParkingSpot(@PathVariable("id") Integer parkingSpotId,
                                          @RequestParam("userEmail") String userEmail) {
        return parkingSpotService.reserve(parkingSpotId, userEmail);
    }

    @PostMapping("/reset/populate")
    public List<ParkingSpot> populateParkingSpots() {
        return parkingSpotService.populateParkingSpots();
    }

    @PostMapping("/reset/reserve")
    public List<ParkingSpot> reserveParkingSpots() {
        return parkingSpotService.reserveParkingSpots();
    }
}
