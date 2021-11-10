package servisi.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import servisi.api.model.OdgovorDTO;
import servisi.api.model.PitanjeDTO;
import servisi.domain.OdgovorFakultet;
import servisi.domain.OdgovorNastavnik;
import servisi.domain.OdgovorPredmet;
import servisi.domain.Pitanje;

@Mapper
public interface ModelMapper {

    ModelMapper instance = Mappers.getMapper(ModelMapper.class);

    @Mappings({
            @Mapping(target="pitanjeId", source="odgovorFakultet.pitanje.id"),
            @Mapping(target="drziPredmetIliPredmetId", source="semestarId"),
    })
    OdgovorDTO odgovorFakultetToOdgovorDTO(OdgovorFakultet odgovorFakultet);

    @Mappings({
            @Mapping(target="pitanjeId", source="odgovorNastavnik.pitanje.id"),
            @Mapping(target="drziPredmetIliPredmetId", source="drziPredmetId"),
    })
    OdgovorDTO odgovorNastavnikToOdgovorDTO(OdgovorNastavnik odgovorNastavnik);

    @Mappings({
            @Mapping(target="pitanjeId", source="odgovorPredmet.pitanje.id"),
            @Mapping(target="drziPredmetIliPredmetId", source="predmetId"),
    })
    OdgovorDTO odgovorPredmetToOdgovorDTO(OdgovorPredmet odgovorPredmet);

    PitanjeDTO pitanjeToPitanjeDTO(Pitanje pitanje);
}
