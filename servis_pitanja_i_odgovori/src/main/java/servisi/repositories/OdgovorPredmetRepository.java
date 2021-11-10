package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import servisi.domain.OdgovorPredmet;

import java.util.List;

@Repository
public interface OdgovorPredmetRepository extends JpaRepository<OdgovorPredmet, Integer> {

    @Query("SELECT odgovor FROM OdgovorPredmet odgovor WHERE odgovor.studentId=:studentId AND " +
            "odgovor.semestarId=:semestarId AND odgovor.predmetId=:predmetId")
    List<OdgovorPredmet> getsAllAnswersAboutSubject(int studentId, int semestarId, int predmetId);

    @Modifying
    @Transactional
    @Query("UPDATE OdgovorPredmet odgovor SET odgovor.studentId = NULL WHERE odgovor.studentId = ?1 " +
            "AND odgovor.semestarId = ?2")
    int makeAnswersAnonymous(int studentId, int semestarId);
}







