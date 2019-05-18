package app.service;

import app.model.ParkingSpot;
import app.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<ParkingSpot> getAllParkingSpotsForParking(Integer parkingId) {
        return parkingSpotRepository.findAllByParkingId(parkingId);
    }

    public List<ParkingSpot> getAllParkingSpotsForUserEmail(String userEmail) {
        return parkingSpotRepository.findAllByUserEmail(userEmail);
    }

    public List<ParkingSpot> getAllFreeParkingSpotsForParking(Integer parkingId) {
        return parkingSpotRepository.findAllByParkingIdAndUserEmailIsNull(parkingId);
    }

    public ParkingSpot reserve(Integer parkingId, Integer parkinSpotId, String userEmail) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setId(parkinSpotId);
        parkingSpot.setParkingId(parkingId);
        parkingSpot.setUserEmail(userEmail);
        return parkingSpotRepository.save(parkingSpot);
    }

    public ParkingSpot free(Integer parkingId, Integer parkinSpotId, String userEmail) {
        Optional<ParkingSpot> parkingSpot1 = parkingSpotRepository.findById(parkinSpotId);

        if(!parkingSpot1.isPresent())
            return null;

        if (!userEmail.equals(parkingSpot1.get().getUserEmail()))
            return null;

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setId(parkinSpotId);
        parkingSpot.setParkingId(parkingId);
        parkingSpot.setUserEmail(null);
        return parkingSpotRepository.save(parkingSpot);
    }

    public List<ParkingSpot> populateParkingSpots() {
        parkingSpotRepository.deleteAll();

        List<ParkingSpot> parkingSpotList = new ArrayList<>();

        for (int j = 1; j <= 4; ++j) {
            for (int i = (j - 1) * 10 + 1; i <= (j - 1) * 10 + 10; ++i) {
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

        for (int i = 1; i <= 5; ++i) {
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.setId(i);
            parkingSpot.setParkingId(1);
            parkingSpot.setUserEmail("example1@test.com");

            parkingSpotList.add(parkingSpot);
        }

        for (int i = 21; i <= 25; ++i) {
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.setId(i);
            parkingSpot.setParkingId(3);
            parkingSpot.setUserEmail("example3@test.com");

            parkingSpotList.add(parkingSpot);
        }

        return parkingSpotRepository.saveAll(parkingSpotList);
    }
}
