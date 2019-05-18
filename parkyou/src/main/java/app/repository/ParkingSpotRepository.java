package app.repository;

        import app.model.ParkingSpot;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface ParkingSpotRepository extends MongoRepository<ParkingSpot, Integer> {

    ParkingSpot findById(int id);

    ParkingSpot findByIdAndParkingId(int id, int parkingId);

    ParkingSpot findByUserEmail(String userEmail);

    List<ParkingSpot> findAllByUserEmailIsNull();
}
