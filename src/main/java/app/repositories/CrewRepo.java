package app.repositories;

import app.models.Crew;
import app.models.SpaceShip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CrewRepo extends CrudRepository<Crew, Long> {

    List<Crew> findAll();
    Optional<Crew> findByDutyShip (SpaceShip dutyShip);


    //List<Crew> findByCrewNameContaining (String text);

    //@Query("SELECT p FROM Crew WHERE " + "p.name LIKE CONCAT('%', :query, '%' )")
    //List<Crew> searchCrew (String query);
}
