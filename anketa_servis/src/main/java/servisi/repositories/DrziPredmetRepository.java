package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import servisi.domain.DrziPredmet;
import servisi.domain.Nastavnik;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrziPredmetRepository extends JpaRepository<DrziPredmet, Integer> {

    @Query("SELECT DISTINCT objekat.nastavnik FROM DrziPredmet objekat WHERE objekat.predmet.id=:predmetId AND " +
            "objekat.semestar.id=:semestarId")
    List<Nastavnik> findProfessorsBySubjectAndSemester(int predmetId, int semestarId);


    @Query("SELECT objekat.id FROM DrziPredmet objekat WHERE objekat.predmet.id=:predmetId AND " +
            "objekat.semestar.id=:semestarId AND objekat.nastavnik.id=:nastavnikId")
    List<Integer> findByNastavnikIdAndPredmetIdAndSemestarId(int nastavnikId,int predmetId, int semestarId);

    @Query("SELECT objekat.nastavnik FROM DrziPredmet objekat WHERE objekat.id=:id")
    Optional<Nastavnik> findProfessorById(int id);

    Optional<DrziPredmet> findById(int id);

}



