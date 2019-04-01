package app.service;

import app.model.ParkingSpot;
import app.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<ParkingSpot> listAllParkingSpotsForUserEmail(String userEmail) {
        return parkingSpotRepository.findByUserEmail(userEmail);
    }
}
