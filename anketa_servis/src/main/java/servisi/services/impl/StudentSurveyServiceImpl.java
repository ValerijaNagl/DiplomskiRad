package servisi.services.impl;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import servisi.domain.ModelsMapper;
import servisi.api.model.*;
import servisi.domain.*;
import servisi.repositories.*;
import servisi.security.service.TokenService;
import servisi.services.StudentSurveyService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Optional;

@Service
public class StudentSurveyServiceImpl implements StudentSurveyService {

    private final StudentRepository studentRepository;
    private final SemestarRepository semestarRepository;
    private final ZakljucenaRepository zakljucenaRepository;
    private final ModelsMapper modelsMapper;
    private final RestTemplate restTemplate;
    private final TokenService tokenService;

    public StudentSurveyServiceImpl(StudentRepository studentRepository,
                                    SemestarRepository semestarRepository,
                                    ZakljucenaRepository zakljucenaRepository,
                                    ModelsMapper modelsMapper,
                                    RestTemplate restTemplate,
                                    TokenService tokenService) {
        this.studentRepository = studentRepository;
        this.semestarRepository = semestarRepository;
        this.zakljucenaRepository = zakljucenaRepository;
        this.modelsMapper = modelsMapper;
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
    }


    @Override
    public StudentDTO findStudentByUsername(String username) {

        if(username.equals("")) return null;

        Optional<Student> optionalStudent = studentRepository.findTopByUsername(username);

        return optionalStudent.map(modelsMapper::studentToStudentDTO).orElse(null);
    }



    @Override
    public StudentDTO getStudentById(int studentId) {
        if(studentId < 1) return null;

        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()) return null;

        return optionalStudent.map(modelsMapper::studentToStudentDTO).orElse(null);
    }


    @Override
    public Boolean isSurveyFilledOut(int studentId, int semestarId) {

        if(studentId<1 || semestarId<1) return false;

        Optional<ZakljucenaAnketa> optionalZakljucenaAnketa = zakljucenaRepository.isSurveyFilledOut(studentId,semestarId);

        return optionalZakljucenaAnketa.isPresent();
    }

    @Override
    public Boolean finishSurvey(int studentId, int semestarId) {
        if(studentId<1 || semestarId<1) return false;

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Semestar> optionalSemestar = semestarRepository.findById(semestarId);

        ResponseEntity<Boolean> responseEntity =
                restTemplate.exchange("/anonymous?studentId=" + studentId + "&semestarId=" + semestarId,
                        HttpMethod.GET, null, Boolean.class);

        if(responseEntity.getBody() == null) return false;

        if(optionalStudent.isPresent() && optionalSemestar.isPresent()){
            ZakljucenaAnketaPk pk = new ZakljucenaAnketaPk(optionalSemestar.get(),optionalStudent.get());
            ZakljucenaAnketa zakljucenaAnketa = new ZakljucenaAnketa(pk);
            zakljucenaRepository.save(zakljucenaAnketa);
            return true;
        }

        return false;
    }

    @Override
    public TokenDTO login(String username) {

        Optional<Student> optionalStudent = studentRepository.findTopByUsername(username);

        if(optionalStudent.isEmpty()) return null;

        Claims claims = Jwts.claims();
        claims.put("id", optionalStudent.get().getId());
        claims.put("role", "ROLE_USER");

        return new TokenDTO(tokenService.generate(claims));
    }


}
