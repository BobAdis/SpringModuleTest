package app.repositories;

import app.models.SpaceShip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpaceShipRepo extends CrudRepository<SpaceShip, Long> {

    List<SpaceShip> findAll();
    List<SpaceShip> findByIsActiveIsTrue();

    Optional<SpaceShip> findByName(String name);
}
