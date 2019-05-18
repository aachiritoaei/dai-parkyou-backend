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

    @GetMapping("/{parkingId}")
    public List<ParkingSpot> getAllParkingSpotsForParking(@PathVariable("parkingId") Integer parkingId) {
        return parkingSpotService.getAllParkingSpotsForParking(parkingId);
    }

    @GetMapping("/{parkingId}/free")
    public List<ParkingSpot> getAllFreeParkingSpotsForParking(@PathVariable("parkingId") Integer parkingId) {
        return parkingSpotService.getAllFreeParkingSpotsForParking(parkingId);
    }

    @GetMapping("/user")
    public List<ParkingSpot> getAllParkingSpotsForUserEmail(@RequestParam("userEmail") String userEmail) {
        return parkingSpotService.getAllParkingSpotsForUserEmail(userEmail);
    }

    @PostMapping("/{parkingId}/{parkingSpotId}")
    public ParkingSpot reserveParkingSpot(@PathVariable("parkingId") Integer parkingId,
                                          @PathVariable("parkingSpotId") Integer parkingSpotId,
                                          @RequestParam("userEmail") String userEmail) {
        return parkingSpotService.reserve(parkingId, parkingSpotId, userEmail);
    }

    @DeleteMapping("/{parkingId}/{parkingSpotId}")
    public ParkingSpot freeParkingSpot(@PathVariable("parkingId") Integer parkingId,
                                       @PathVariable("parkingSpotId") Integer parkingSpotId,
                                       @RequestParam("userEmail") String userEmail) {
        return parkingSpotService.free(parkingId, parkingSpotId, userEmail);
    }

    @PostMapping("/reset/populate")
    public void populateParkingSpots() {
        parkingService.populateParkings();
        parkingSpotService.populateParkingSpots();
        parkingSpotService.reserveParkingSpots();
    }
}
