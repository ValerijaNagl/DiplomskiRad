package servisi.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import servisi.api.model.*;

@Mapper
public interface ModelsMapper {

    ModelsMapper instance = Mappers.getMapper(ModelsMapper.class);

    StudentDTO studentToStudentDTO(Student student);
    SemestarDTO semestarToSemestarDTO(Semestar semestar);
    NastavnikDTO nastavnikToNastavnikDTO(Nastavnik nastavnik);
    PredmetDTO predmetToPredmetDTO(Predmet predmet);

    @Mappings({
            @Mapping(target="nastavnikId", source="drziPredmet.nastavnik.id"),
            @Mapping(target="semestarId", source="drziPredmet.semestar.id"),
            @Mapping(target="predmetId", source="drziPredmet.predmet.id"),
            @Mapping(target="id", source="id"),
            @Mapping(target="grupa", source="grupa")
    })
    DrziPredmetDTO drziPredmetToDrziPredmetDTO(DrziPredmet drziPredmet);
}
