package servisi.services.impl;

import org.springframework.stereotype.Service;
import servisi.api.model.PredmetDTO;
import servisi.api.model.SemestarDTO;
import servisi.domain.*;
import servisi.repositories.PredmetRepository;
import servisi.repositories.SemestarRepository;
import servisi.repositories.StudentPredmetSemestarRepository;
import servisi.repositories.StudentRepository;
import servisi.services.SemestarPredmetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SemestarPredmetServiceImpl implements SemestarPredmetService {

    private final SemestarRepository semestarRepository;
    private final PredmetRepository predmetRepository;
    private final StudentRepository studentRepository;
    private final StudentPredmetSemestarRepository studentPredmetSemestarRepository;
    private final ModelsMapper modelsMapper;

    public SemestarPredmetServiceImpl(SemestarRepository semestarRepository, PredmetRepository predmetRepository, StudentRepository studentRepository, StudentPredmetSemestarRepository studentPredmetSemestarRepository, ModelsMapper modelsMapper) {
        this.semestarRepository = semestarRepository;
        this.predmetRepository = predmetRepository;
        this.studentRepository = studentRepository;
        this.studentPredmetSemestarRepository = studentPredmetSemestarRepository;
        this.modelsMapper = modelsMapper;
    }


    @Override
    public SemestarDTO getSemestarById(int semestarId) {

        if(semestarId < 1) return null;
        Optional<Semestar> optionalSemestar = semestarRepository.findById(semestarId);

        if(optionalSemestar.isEmpty()) return null;

        return optionalSemestar.map(modelsMapper::semestarToSemestarDTO).orElse(null);
    }

    @Override
    public PredmetDTO getSubjectById(int predmetId) {
        Optional<Predmet> optionalPredmet = predmetRepository.findById(predmetId);
        if(optionalPredmet.isEmpty()) return null;
        return optionalPredmet.map(modelsMapper::predmetToPredmetDTO).orElse(null);
    }



    @Override
    public SemestarDTO getMaxSemestar() {
        Integer maxId = semestarRepository.getMaxId();

        if(maxId == null) return null;
        Optional<Semestar> optionalSemestar = semestarRepository.findById(maxId);

        return optionalSemestar.map(modelsMapper::semestarToSemestarDTO).orElse(null);
    }

    @Override
    public List<PredmetDTO> getStudentsSubjectsInSemestar(String username, int semestarId) {
        if(username.trim().equals("") || semestarId<1) return null;

        Optional<Student> optionalStudent = studentRepository.findTopByUsername(username);

        if(!optionalStudent.isPresent()) return null;

        List<StudentPredmetSemestar> lista = studentPredmetSemestarRepository.getAllPredmetiOfStudent(optionalStudent.get().getId(),semestarId);
        List<PredmetDTO> toReturn = new ArrayList<>();

        for(StudentPredmetSemestar studentPredmetSemestar : lista){
            Predmet p = studentPredmetSemestar.getPk().getPredmet();
            toReturn.add(modelsMapper.predmetToPredmetDTO(p));
        }

        return toReturn;
    }
}
