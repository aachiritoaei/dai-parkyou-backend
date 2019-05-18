package app.repository;

import app.model.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends MongoRepository<Parking, Integer> {

    Parking findById(int id);
}
