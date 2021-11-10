package servisi.services;

import servisi.api.model.DrziPredmetDTO;
import servisi.api.model.NastavnikDTO;

import java.util.List;

public interface NastavnikService {

    List<NastavnikDTO> findProfessorsBySubjectAndSemester(int predmetId, int semestarId);
    NastavnikDTO getProfessorBySubjectAndSemester(int predmetId, int semestarId, int profesorId);

    NastavnikDTO getProfessorById(int nastavnikId);
    DrziPredmetDTO getDrziPredmetById(int drziPredmetId);
}
