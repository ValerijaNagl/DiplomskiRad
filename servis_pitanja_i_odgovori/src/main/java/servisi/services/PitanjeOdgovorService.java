package servisi.services;

import servisi.api.model.OdgovorDTO;
import servisi.api.model.PitanjeDTO;

import java.util.List;

public interface PitanjeOdgovorService {
    Boolean saveAnswersAboutUni(List<OdgovorDTO> answers);
    Boolean saveAnswersAboutProf(List<OdgovorDTO> answers);
    Boolean saveAnswersAboutSub(List<OdgovorDTO> answers);
    List<OdgovorDTO> getsAllAnswersAboutUni(int studentId, int semestarId);
    List<OdgovorDTO> getsAllAnswersAboutProfessors(int studentId, int semestarId, int drziPredmetId);
    List<OdgovorDTO> getsAllAnswersAboutSubjects(int studentId, int semestarId, int predmetId);
    List<PitanjeDTO> getQuestionsByType(String tip);
    Boolean makeAnswersAnonymous(int studentId, int semestarId);
}




