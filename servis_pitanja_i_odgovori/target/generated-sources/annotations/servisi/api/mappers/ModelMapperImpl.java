package servisi.api.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import servisi.api.model.OdgovorDTO;
import servisi.api.model.PitanjeDTO;
import servisi.domain.OdgovorFakultet;
import servisi.domain.OdgovorNastavnik;
import servisi.domain.OdgovorPredmet;
import servisi.domain.Pitanje;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-05T16:54:35+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class ModelMapperImpl implements ModelMapper {

    @Override
    public OdgovorDTO odgovorFakultetToOdgovorDTO(OdgovorFakultet odgovorFakultet) {
        if ( odgovorFakultet == null ) {
            return null;
        }

        OdgovorDTO odgovorDTO = new OdgovorDTO();

        odgovorDTO.setPitanjeId( odgovorFakultetPitanjeId( odgovorFakultet ) );
        odgovorDTO.setDrziPredmetIliPredmetId( odgovorFakultet.getSemestarId() );
        odgovorDTO.setId( odgovorFakultet.getId() );
        odgovorDTO.setStudentId( odgovorFakultet.getStudentId() );
        odgovorDTO.setSemestarId( odgovorFakultet.getSemestarId() );
        odgovorDTO.setOdgovor( odgovorFakultet.getOdgovor() );

        return odgovorDTO;
    }

    @Override
    public OdgovorDTO odgovorNastavnikToOdgovorDTO(OdgovorNastavnik odgovorNastavnik) {
        if ( odgovorNastavnik == null ) {
            return null;
        }

        OdgovorDTO odgovorDTO = new OdgovorDTO();

        odgovorDTO.setPitanjeId( odgovorNastavnikPitanjeId( odgovorNastavnik ) );
        odgovorDTO.setDrziPredmetIliPredmetId( odgovorNastavnik.getDrziPredmetId() );
        odgovorDTO.setId( odgovorNastavnik.getId() );
        odgovorDTO.setStudentId( odgovorNastavnik.getStudentId() );
        odgovorDTO.setSemestarId( odgovorNastavnik.getSemestarId() );
        odgovorDTO.setOdgovor( odgovorNastavnik.getOdgovor() );

        return odgovorDTO;
    }

    @Override
    public OdgovorDTO odgovorPredmetToOdgovorDTO(OdgovorPredmet odgovorPredmet) {
        if ( odgovorPredmet == null ) {
            return null;
        }

        OdgovorDTO odgovorDTO = new OdgovorDTO();

        odgovorDTO.setPitanjeId( odgovorPredmetPitanjeId( odgovorPredmet ) );
        odgovorDTO.setDrziPredmetIliPredmetId( odgovorPredmet.getPredmetId() );
        odgovorDTO.setId( odgovorPredmet.getId() );
        odgovorDTO.setStudentId( odgovorPredmet.getStudentId() );
        odgovorDTO.setSemestarId( odgovorPredmet.getSemestarId() );
        odgovorDTO.setOdgovor( odgovorPredmet.getOdgovor() );

        return odgovorDTO;
    }

    @Override
    public PitanjeDTO pitanjeToPitanjeDTO(Pitanje pitanje) {
        if ( pitanje == null ) {
            return null;
        }

        int id = 0;
        String tekst = null;
        String tip = null;
        String format = null;

        id = pitanje.getId();
        tekst = pitanje.getTekst();
        tip = pitanje.getTip();
        format = pitanje.getFormat();

        PitanjeDTO pitanjeDTO = new PitanjeDTO( id, tekst, tip, format );

        return pitanjeDTO;
    }

    private Integer odgovorFakultetPitanjeId(OdgovorFakultet odgovorFakultet) {
        if ( odgovorFakultet == null ) {
            return null;
        }
        Pitanje pitanje = odgovorFakultet.getPitanje();
        if ( pitanje == null ) {
            return null;
        }
        int id = pitanje.getId();
        return id;
    }

    private Integer odgovorNastavnikPitanjeId(OdgovorNastavnik odgovorNastavnik) {
        if ( odgovorNastavnik == null ) {
            return null;
        }
        Pitanje pitanje = odgovorNastavnik.getPitanje();
        if ( pitanje == null ) {
            return null;
        }
        int id = pitanje.getId();
        return id;
    }

    private Integer odgovorPredmetPitanjeId(OdgovorPredmet odgovorPredmet) {
        if ( odgovorPredmet == null ) {
            return null;
        }
        Pitanje pitanje = odgovorPredmet.getPitanje();
        if ( pitanje == null ) {
            return null;
        }
        int id = pitanje.getId();
        return id;
    }
}
