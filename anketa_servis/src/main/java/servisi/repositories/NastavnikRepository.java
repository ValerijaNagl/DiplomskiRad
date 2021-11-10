package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servisi.domain.Nastavnik;

import java.util.Optional;

@Repository
public interface NastavnikRepository extends JpaRepository<Nastavnik,Integer> {

    Optional<Nastavnik> findById(int id);
}
