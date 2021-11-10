package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import servisi.domain.Semestar;

import java.util.Optional;

@Repository
public interface SemestarRepository extends JpaRepository<Semestar, Long> {

    @Query(" SELECT MAX(id) FROM Semestar ")
    Integer getMaxId();

    Optional<Semestar> findById(int id);
}
