package app.repository;

import app.model.ParkingSpot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotRepository extends MongoRepository<ParkingSpot, Integer> {

    List<ParkingSpot> findByUserEmail(String userEmail);
}
