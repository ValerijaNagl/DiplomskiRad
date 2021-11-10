package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servisi.domain.Predmet;

import java.util.Optional;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet,Long> {

    Optional<Predmet> findById(int id);
}
