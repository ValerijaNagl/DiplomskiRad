package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import servisi.domain.ZakljucenaAnketa;
import servisi.domain.ZakljucenaAnketaPk;

import java.util.Optional;

@Repository
public interface ZakljucenaRepository extends JpaRepository<ZakljucenaAnketa, ZakljucenaAnketaPk> {

    @Query("SELECT objekat FROM ZakljucenaAnketa objekat WHERE objekat.pk.student.id=:studentId AND " +
            "objekat.pk.semestar.id=:semestarId")
    Optional<ZakljucenaAnketa> isSurveyFilledOut(int studentId, int semestarId);
}
