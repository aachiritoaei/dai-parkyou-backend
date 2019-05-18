package app.service;

import app.model.Parking;
import app.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService {

    private ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    public List<Parking> populateParkings() {
        List<Parking> parkingList = new ArrayList<>();

        Parking parking1 = new Parking();
        parking1.setId(1);
        parking1.setName("Parcare Unirii");
        parking1.setLatitude(44.428843);
        parking1.setLongitude(26.105121);

        Parking parking2 = new Parking();
        parking2.setId(2);
        parking2.setName("Parcare Victoriei");
        parking2.setLatitude(44.452707);
        parking2.setLongitude(26.085855);

        Parking parking3 = new Parking();
        parking3.setId(3);
        parking3.setName("Parcare Izvor");
        parking3.setLatitude(44.434538);
        parking3.setLongitude(26.086871);

        Parking parking4 = new Parking();
        parking4.setId(4);
        parking4.setName("Parcare Parlament");
        parking4.setLatitude(44.427330);
        parking4.setLongitude(26.091445);

        parkingList.add(parking1);
        parkingList.add(parking2);
        parkingList.add(parking3);
        parkingList.add(parking4);

        return parkingRepository.saveAll(parkingList);
    }
}
