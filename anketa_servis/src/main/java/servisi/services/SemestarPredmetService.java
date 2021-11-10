package servisi.services;

import servisi.api.model.PredmetDTO;
import servisi.api.model.SemestarDTO;

import java.util.List;

public interface SemestarPredmetService {

    SemestarDTO getMaxSemestar();
    SemestarDTO getSemestarById(int semestarId);

    PredmetDTO getSubjectById(int predmetId);
    List<PredmetDTO> getStudentsSubjectsInSemestar(String username, int semestarId);
}
