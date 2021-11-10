package servisi.services.impl;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import servisi.api.mappers.ModelMapper;
import servisi.api.model.*;
import servisi.domain.OdgovorFakultet;
import servisi.domain.OdgovorNastavnik;
import servisi.domain.OdgovorPredmet;
import servisi.domain.Pitanje;
import servisi.repositories.OdgovorFakultetRepository;
import servisi.repositories.OdgovorNastavnikRepository;
import servisi.repositories.OdgovorPredmetRepository;
import servisi.repositories.PitanjeRepository;
import servisi.services.PitanjeOdgovorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PitanjeOdgovorServiceImpl implements PitanjeOdgovorService {

    private final PitanjeRepository pitanjeRepository;
    private final OdgovorFakultetRepository odgovorFakultetRepository;
    private final OdgovorNastavnikRepository odgovorNastavnikRepository;
    private final OdgovorPredmetRepository odgovorPredmetRepository;
    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    public PitanjeOdgovorServiceImpl(PitanjeRepository pitanjeRepository,
                                     OdgovorFakultetRepository odgovorFakultetRepository,
                                     OdgovorNastavnikRepository odgovorNastavnikRepository,
                                     OdgovorPredmetRepository odgovorPredmetRepository,
                                     RestTemplate restTemplate, ModelMapper modelMapper) {
        this.pitanjeRepository = pitanjeRepository;
        this.odgovorFakultetRepository = odgovorFakultetRepository;
        this.odgovorNastavnikRepository = odgovorNastavnikRepository;
        this.odgovorPredmetRepository = odgovorPredmetRepository;
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean saveAnswersAboutUni(List<OdgovorDTO> answers) {
        if(answers.size()==0) return false;

        ResponseEntity<StudentDTO> studentDTO =
                restTemplate.exchange("/students/student?id=" + answers.get(0).getStudentId(),
                HttpMethod.GET, null, StudentDTO.class);

        ResponseEntity<SemestarDTO> semestarDTO =
                restTemplate.exchange("/semestarAndSubjects/semester?id=" + answers.get(0).getSemestarId(),
                HttpMethod.GET, null, SemestarDTO.class);

        if(studentDTO.getBody()==null && semestarDTO.getBody()==null) return false;

        for(OdgovorDTO odgovorDTO : answers){
            Optional<Pitanje> optionalPitanje = pitanjeRepository.findById(odgovorDTO.getPitanjeId());
            if(optionalPitanje.isPresent()){
                OdgovorFakultet odgovor = new OdgovorFakultet();
                odgovor.setOdgovor(odgovorDTO.getOdgovor());
                odgovor.setPitanje(optionalPitanje.get());
                odgovor.setSemestarId(semestarDTO.getBody().getId());
                odgovor.setStudentId(studentDTO.getBody().getId());
                odgovorFakultetRepository.save(odgovor);
            }
        }
        return true;
    }

    @Override
    public Boolean saveAnswersAboutProf(List<OdgovorDTO> answers) {
        if(answers.size()==0) return false;

        ResponseEntity<StudentDTO> studentDTO =
                restTemplate.exchange("/students/student?id=" + answers.get(0).getStudentId(),
                HttpMethod.GET, null, StudentDTO.class);

        ResponseEntity<SemestarDTO> semestarDTO =
                restTemplate.exchange("/semestarAndSubjects/semester?id=" + answers.get(0).getSemestarId(),
                HttpMethod.GET, null, SemestarDTO.class);

        ResponseEntity<DrziPredmetDTO> drziPredmetDTO =
               restTemplate.exchange("/professors/teachesSubject?id=" + answers.get(0).getDrziPredmetIliPredmetId(),
                       HttpMethod.GET, null, DrziPredmetDTO.class);

        if(studentDTO.getBody()==null && semestarDTO.getBody()==null && drziPredmetDTO.getBody()==null) return false;

        for(OdgovorDTO odgovorDTO : answers){
            Optional<Pitanje> optionalPitanje = pitanjeRepository.findById(odgovorDTO.getPitanjeId());
            if(optionalPitanje.isPresent()){
                OdgovorNastavnik odgovor = new OdgovorNastavnik();
                odgovor.setOdgovor(odgovorDTO.getOdgovor());
                odgovor.setPitanje(optionalPitanje.get());
                odgovor.setSemestarId(semestarDTO.getBody().getId());
                odgovor.setStudentId(studentDTO.getBody().getId());
                odgovor.setDrziPredmetId(drziPredmetDTO.getBody().getId());
                odgovorNastavnikRepository.save(odgovor);
            }
        }
        return true;
    }

    @Override
    public Boolean saveAnswersAboutSub(List<OdgovorDTO> answers) {
        if(answers.size()==0) return false;

        ResponseEntity<StudentDTO> studentDTO =
                restTemplate.exchange("/students/student?id=" + answers.get(0).getStudentId(),
                HttpMethod.GET, null, StudentDTO.class);

        ResponseEntity<SemestarDTO> semestarDTO =
                restTemplate.exchange("/semestarAndSubjects/semester?id=" + answers.get(0).getSemestarId(),
                HttpMethod.GET, null, SemestarDTO.class);

        ResponseEntity<PredmetDTO> predmetDTO =
                restTemplate.exchange("/semestarAndSubjects/subject?id=" +
                        answers.get(0).getDrziPredmetIliPredmetId(), HttpMethod.GET, null, PredmetDTO.class);

        if(studentDTO.getBody()==null && semestarDTO.getBody()==null && predmetDTO.getBody()==null) return false;

        for(OdgovorDTO odgovorDTO : answers){
            Optional<Pitanje> optionalPitanje = pitanjeRepository.findById(odgovorDTO.getPitanjeId());
            if(optionalPitanje.isPresent()){
                OdgovorPredmet odgovor = new OdgovorPredmet();
                odgovor.setOdgovor(odgovorDTO.getOdgovor());
                odgovor.setPitanje(optionalPitanje.get());
                odgovor.setSemestarId(semestarDTO.getBody().getId());
                odgovor.setStudentId(studentDTO.getBody().getId());
                odgovor.setPredmetId(predmetDTO.getBody().getId());
                odgovorPredmetRepository.save(odgovor);
            }
        }
        return true;
    }

    @Override
    public List<OdgovorDTO> getsAllAnswersAboutUni(int studentId, int semestarId) {
        if(studentId<1 || semestarId<1) return null;

        List<OdgovorFakultet> odgovori = odgovorFakultetRepository.findByStudent_IdAndSemestar_Id(studentId,semestarId);
        List<OdgovorDTO> toReturn = new ArrayList<>();
        for(OdgovorFakultet odg : odgovori){
            toReturn.add(modelMapper.odgovorFakultetToOdgovorDTO(odg));
        }
        return toReturn;
    }

    @Override
    public List<OdgovorDTO> getsAllAnswersAboutProfessors(int studentId, int semestarId, int drziPredmetId) {
        if(studentId<1 || semestarId<1) return null;

        List<OdgovorNastavnik> odgovori =
                odgovorNastavnikRepository.getsAllAnswersAboutSubject(studentId,semestarId,drziPredmetId);
        List<OdgovorDTO> toReturn = new ArrayList<>();
        for(OdgovorNastavnik odg : odgovori){
           toReturn.add(modelMapper.odgovorNastavnikToOdgovorDTO(odg));
        }
        return toReturn;
    }

    @Override
    public List<OdgovorDTO> getsAllAnswersAboutSubjects(int studentId, int semestarId, int predmetId){
        if(studentId<1 || semestarId<1 || predmetId<1) return null;

        List<OdgovorPredmet> odgovori =
                odgovorPredmetRepository.getsAllAnswersAboutSubject(studentId,semestarId,predmetId);
        List<OdgovorDTO> toReturn = new ArrayList<>();
        for(OdgovorPredmet odg : odgovori){
            toReturn.add(modelMapper.odgovorPredmetToOdgovorDTO(odg));
        }
        return toReturn;
    }



    @Override
    public List<PitanjeDTO> getQuestionsByType(String tip) {
        if(tip.trim().equals("")) return null;

        List<Pitanje> pitanjaFakultet = pitanjeRepository.findQuestionsByType(tip);
        List<PitanjeDTO> toReturn = new ArrayList<>();
        for(Pitanje pitanje : pitanjaFakultet){
            toReturn.add(modelMapper.pitanjeToPitanjeDTO(pitanje));
        }
        return toReturn;
    }


    @Override
    public Boolean makeAnswersAnonymous(int studentId,int semestarId) {
        int numOfAnswers1 = odgovorFakultetRepository.makeAnswersAnonymous(studentId,semestarId);
        int numOfAnswers2 = odgovorNastavnikRepository.makeAnswersAnonymous(studentId,semestarId);
        int numOfAnswers3 = odgovorPredmetRepository.makeAnswersAnonymous(studentId,semestarId);

        if(numOfAnswers1 > 0 && numOfAnswers2 > 0  && numOfAnswers3 > 0) return true;
        else return null;
    }
}


