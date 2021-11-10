package servisi.services;

import servisi.api.model.StudentDTO;
import servisi.api.model.TokenDTO;

public interface StudentSurveyService {
    StudentDTO findStudentByUsername(String username);
    StudentDTO getStudentById(int studentId);

    Boolean isSurveyFilledOut(int studentId, int semestarId);
    Boolean finishSurvey(int studentId, int semestarId);

    TokenDTO login(String username);


}
