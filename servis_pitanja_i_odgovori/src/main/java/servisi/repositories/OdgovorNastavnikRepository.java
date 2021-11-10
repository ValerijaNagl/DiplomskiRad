package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import servisi.domain.OdgovorNastavnik;

import java.util.List;

@Repository
public interface OdgovorNastavnikRepository extends JpaRepository<OdgovorNastavnik,Integer> {

    @Query("SELECT odgovor FROM OdgovorNastavnik odgovor WHERE odgovor.studentId=:studentId AND " +
            "odgovor.semestarId=:semestarId AND odgovor.drziPredmetId=:drziPredmet")
    List<OdgovorNastavnik> getsAllAnswersAboutSubject(int studentId, int semestarId, int drziPredmet);

    @Modifying
    @Transactional
    @Query("UPDATE OdgovorNastavnik odgovor SET odgovor.studentId = NULL WHERE odgovor.studentId = ?1 " +
            "AND odgovor.semestarId = ?2")
    int makeAnswersAnonymous(int studentId, int semestarId);
}
