package app.services;


import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceShipService {

    private final SpaceShipRepo spaceShipRepo;

    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> getAllSpaceship() {
        return spaceShipRepo.findAll();
    }

    public List<SpaceShip> getAllActiveSpaceship() {
        return spaceShipRepo.findByIsActiveIsTrue();
    }

    public Optional<SpaceShip> getShip (String ship) {
        return spaceShipRepo.findByName(ship);
    }

}
