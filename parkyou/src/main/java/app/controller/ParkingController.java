package app.controller;

import app.model.Parking;
import app.model.ParkingSpot;
import app.service.ParkingService;
import app.service.ParkingSpotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/parking")
public class ParkingController {

    private ParkingService parkingService;
    private ParkingSpotService parkingSpotService;

    public ParkingController(ParkingService parkingService,
                             ParkingSpotService parkingSpotService) {
        this.parkingService = parkingService;
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping("/all")
    public List<Parking> getAllParkings() {
        return parkingService.getAllParkings();
    }

    @GetMapping("/{id}")
    public List<ParkingSpot> getAllParkingSpots(@PathVariable("id") Integer parkingId) {
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
