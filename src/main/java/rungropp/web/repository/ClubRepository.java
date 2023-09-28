package rungropp.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rungropp.web.models.Club;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {

    Optional<Club> findByTitle(String url);
}
