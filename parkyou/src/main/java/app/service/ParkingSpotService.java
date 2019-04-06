package app.service;

import app.model.ParkingSpot;
import app.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot getParkingSpotById(int id) {
        return parkingSpotRepository.findById(id);
    }

    public ParkingSpot getParkingSpotByUserEmail(String userEmail) {
        return parkingSpotRepository.findByUserEmail(userEmail);
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }

    public List<ParkingSpot> getAllFreeParkingSpots() {
        return parkingSpotRepository.findAllByUserEmailIsNull();
    }

    public List<ParkingSpot> populateParkingSpots() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        for (int i = 1; i <= 100; ++i) {
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.setId(i);

            parkingSpotList.add(parkingSpot);
        }

        return parkingSpotRepository.saveAll(parkingSpotList);
    }

    public List<ParkingSpot> reserveParkingSpots() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        ParkingSpot parkingSpot1 = new ParkingSpot();
        parkingSpot1.setId(1);
        parkingSpot1.setUserEmail("example1@example.com");
        parkingSpotList.add(parkingSpot1);

        ParkingSpot parkingSpot25 = new ParkingSpot();
        parkingSpot25.setId(25);
        parkingSpot25.setUserEmail("example25@example.com");
        parkingSpotList.add(parkingSpot25);

        ParkingSpot parkingSpot36 = new ParkingSpot();
        parkingSpot36.setId(36);
        parkingSpot36.setUserEmail("example36@example.com");
        parkingSpotList.add(parkingSpot36);

        ParkingSpot parkingSpot99 = new ParkingSpot();
        parkingSpot99.setId(99);
        parkingSpot99.setUserEmail("example99@example.com");
        parkingSpotList.add(parkingSpot99);

        return parkingSpotRepository.saveAll(parkingSpotList);
    }
}
