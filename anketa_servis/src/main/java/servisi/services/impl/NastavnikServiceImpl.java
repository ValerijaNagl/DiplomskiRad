package servisi.services.impl;

import org.springframework.stereotype.Service;
import servisi.api.model.DrziPredmetDTO;
import servisi.api.model.NastavnikDTO;
import servisi.domain.DrziPredmet;
import servisi.domain.ModelsMapper;
import servisi.domain.Nastavnik;
import servisi.repositories.DrziPredmetRepository;
import servisi.repositories.NastavnikRepository;
import servisi.services.NastavnikService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NastavnikServiceImpl implements NastavnikService {

    private final DrziPredmetRepository drziPredmetRepository;
    private final NastavnikRepository nastavnikRepository;
    private final ModelsMapper modelsMapper;

    public NastavnikServiceImpl(DrziPredmetRepository drziPredmetRepository,
                                NastavnikRepository nastavnikRepository,
                                ModelsMapper modelsMapper) {
        this.drziPredmetRepository = drziPredmetRepository;
        this.nastavnikRepository = nastavnikRepository;
        this.modelsMapper = modelsMapper;
    }

    @Override
    public List<NastavnikDTO> findProfessorsBySubjectAndSemester(int predmetId, int semestarId) {
        List<Nastavnik> list = drziPredmetRepository.findProfessorsBySubjectAndSemester(predmetId,semestarId);
        List<NastavnikDTO> toReturn = new ArrayList<>();

        for(Nastavnik nastavnik : list){
            Optional<Nastavnik> optionalNastavnik = nastavnikRepository.findById(nastavnik.getId());

            optionalNastavnik.ifPresent(value -> toReturn.add(modelsMapper.nastavnikToNastavnikDTO(value)));
        }

        return toReturn;
    }

    @Override
    public NastavnikDTO getProfessorBySubjectAndSemester(int predmetId, int semestarId, int profesorId) {
        List<Integer> ids =
                drziPredmetRepository.findByNastavnikIdAndPredmetIdAndSemestarId(profesorId,predmetId,semestarId);
        if(ids.size() == 0) return null;
        Optional<DrziPredmet> optionalDrziPredmet = drziPredmetRepository.findById(ids.get(0));
        Optional<Nastavnik> optionalNastavnik = nastavnikRepository.findById(profesorId);

        if(optionalDrziPredmet.isEmpty()) return null;

        if(optionalNastavnik.isPresent() && optionalDrziPredmet.isPresent()){
            return new NastavnikDTO(optionalDrziPredmet.get().getId(), optionalNastavnik.get().getIme(),
                    optionalNastavnik.get().getPrezime(), optionalNastavnik.get().getTip(),
                    optionalNastavnik.get().getEmail());
        }
        return null;
    }

    @Override
    public NastavnikDTO getProfessorById(int drziPredmetId) {
        if(drziPredmetId < 0) return null;
        Optional<Nastavnik> optionalNastavnik = drziPredmetRepository.findProfessorById(drziPredmetId);

        if(optionalNastavnik.isEmpty()) return null;

        if(optionalNastavnik.isPresent()){
            return modelsMapper.nastavnikToNastavnikDTO(optionalNastavnik.get());
        }
        return null;
    }

    @Override
    public DrziPredmetDTO getDrziPredmetById(int drziPredmetId) {
        if(drziPredmetId < 0) return null;
        Optional<DrziPredmet> optionalDrziPredmet = drziPredmetRepository.findById(drziPredmetId);
        if(optionalDrziPredmet.isEmpty()) return null;

        return optionalDrziPredmet.map(modelsMapper::drziPredmetToDrziPredmetDTO).orElse(null);
    }
}
