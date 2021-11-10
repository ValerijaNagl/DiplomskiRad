package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import servisi.domain.OdgovorFakultet;

import java.util.List;
import java.util.Optional;

@Repository
public interface OdgovorFakultetRepository extends JpaRepository<OdgovorFakultet, Integer> {

    @Query("SELECT odgovor FROM OdgovorFakultet odgovor WHERE odgovor.studentId=:studentId AND odgovor.semestarId=:semestarId")
    List<OdgovorFakultet> findByStudent_IdAndSemestar_Id(int studentId, int semestarId);

    @Query("SELECT odgovor FROM OdgovorFakultet odgovor WHERE odgovor.studentId=:studentId " +
            "AND odgovor.semestarId=:semestarId AND odgovor.pitanje.id=:pitanjeId")
    Optional<OdgovorFakultet> getsAnswerAboutUni(int studentId, int semestarId, int pitanjeId);

    @Modifying
    @Transactional
    @Query("UPDATE OdgovorFakultet odgovor SET odgovor.studentId = NULL WHERE odgovor.studentId = ?1 " +
            "AND odgovor.semestarId = ?2")
    int makeAnswersAnonymous(int studentId, int semestarId);
}
