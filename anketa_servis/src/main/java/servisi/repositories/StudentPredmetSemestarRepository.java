package servisi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import servisi.domain.StudentPredmetSemestar;
import servisi.domain.StudentPredmetSemestarPk;

import java.util.List;

@Repository
public interface StudentPredmetSemestarRepository extends JpaRepository<StudentPredmetSemestar, StudentPredmetSemestarPk> {

    @Query("SELECT objekat FROM StudentPredmetSemestar objekat WHERE objekat.pk.student.id=:studentId AND " +
            "objekat.pk.semestar.id=:semestarId")
    List<StudentPredmetSemestar> getAllPredmetiOfStudent(int studentId, int semestarId);
}
