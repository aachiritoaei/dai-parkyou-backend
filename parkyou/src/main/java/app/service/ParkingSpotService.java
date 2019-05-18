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

    public ParkingSpot reserve(Integer parkinSpotId, String userEmail) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setId(parkinSpotId);
        parkingSpot.setUserEmail(userEmail);
        return parkingSpotRepository.save(parkingSpot);
    }

    public List<ParkingSpot> populateParkingSpots() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        for (int j = 1; j <= 4; ++j) {
            for (int i = 1; i <= 10; ++i) {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(i);
                parkingSpot.setParkingId(j);

                parkingSpotList.add(parkingSpot);
            }
        }

        return parkingSpotRepository.saveAll(parkingSpotList);
    }

    public List<ParkingSpot> reserveParkingSpots() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        ParkingSpot parkingSpot1 = new ParkingSpot();
        parkingSpot1.setId(1);
        parkingSpot1.setParkingId(1);
        parkingSpot1.setUserEmail("example11@example.com");
        parkingSpotList.add(parkingSpot1);

        ParkingSpot parkingSpot2 = new ParkingSpot();
        parkingSpot2.setId(2);
        parkingSpot2.setParkingId(2);
        parkingSpot2.setUserEmail("example22@example.com");
        parkingSpotList.add(parkingSpot2);

        ParkingSpot parkingSpot3 = new ParkingSpot();
        parkingSpot3.setId(3);
        parkingSpot3.setParkingId(3);
        parkingSpot3.setUserEmail("example33@example.com");
        parkingSpotList.add(parkingSpot3);

        ParkingSpot parkingSpot4 = new ParkingSpot();
        parkingSpot4.setId(4);
        parkingSpot4.setParkingId(4);
        parkingSpot4.setUserEmail("example44@example.com");
        parkingSpotList.add(parkingSpot4);

        return parkingSpotRepository.saveAll(parkingSpotList);
    }
}
