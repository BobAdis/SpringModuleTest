package app.repositories;

import app.models.Officer;
import org.springframework.data.repository.CrudRepository;

public interface OfficerRepo extends CrudRepository<Officer, Long> {
    Officer findByUsername(String username);
    //Officer loadUserByUsername(String username);
}