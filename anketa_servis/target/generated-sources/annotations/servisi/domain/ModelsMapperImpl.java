package servisi.domain;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import servisi.api.model.DrziPredmetDTO;
import servisi.api.model.NastavnikDTO;
import servisi.api.model.PredmetDTO;
import servisi.api.model.SemestarDTO;
import servisi.api.model.StudentDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-05T15:56:59+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class ModelsMapperImpl implements ModelsMapper {

    @Override
    public StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        int id = 0;
        String username = null;
        String ime = null;
        String prezime = null;
        String smer = null;
        String indeks = null;
        String godinaUpisa = null;

        id = student.getId();
        username = student.getUsername();
        ime = student.getIme();
        prezime = student.getPrezime();
        smer = student.getSmer();
        indeks = student.getIndeks();
        godinaUpisa = student.getGodinaUpisa();

        StudentDTO studentDTO = new StudentDTO( id, username, ime, prezime, smer, indeks, godinaUpisa );

        return studentDTO;
    }

    @Override
    public SemestarDTO semestarToSemestarDTO(Semestar semestar) {
        if ( semestar == null ) {
            return null;
        }

        int id = 0;
        String tipSemestra = null;
        String skolskaGodina = null;

        id = semestar.getId();
        tipSemestra = semestar.getTipSemestra();
        skolskaGodina = semestar.getSkolskaGodina();

        SemestarDTO semestarDTO = new SemestarDTO( id, tipSemestra, skolskaGodina );

        return semestarDTO;
    }

    @Override
    public NastavnikDTO nastavnikToNastavnikDTO(Nastavnik nastavnik) {
        if ( nastavnik == null ) {
            return null;
        }

        int id = 0;
        String ime = null;
        String prezime = null;
        String tip = null;
        String email = null;

        id = nastavnik.getId();
        ime = nastavnik.getIme();
        prezime = nastavnik.getPrezime();
        tip = nastavnik.getTip();
        email = nastavnik.getEmail();

        NastavnikDTO nastavnikDTO = new NastavnikDTO( id, ime, prezime, tip, email );

        return nastavnikDTO;
    }

    @Override
    public PredmetDTO predmetToPredmetDTO(Predmet predmet) {
        if ( predmet == null ) {
            return null;
        }

        int id = 0;
        String naziv = null;

        id = predmet.getId();
        naziv = predmet.getNaziv();

        PredmetDTO predmetDTO = new PredmetDTO( id, naziv );

        return predmetDTO;
    }

    @Override
    public DrziPredmetDTO drziPredmetToDrziPredmetDTO(DrziPredmet drziPredmet) {
        if ( drziPredmet == null ) {
            return null;
        }

        int nastavnikId = 0;
        int semestarId = 0;
        int predmetId = 0;
        int id = 0;
        String grupa = null;

        nastavnikId = drziPredmetNastavnikId( drziPredmet );
        semestarId = drziPredmetSemestarId( drziPredmet );
        predmetId = drziPredmetPredmetId( drziPredmet );
        id = drziPredmet.getId();
        grupa = drziPredmet.getGrupa();

        DrziPredmetDTO drziPredmetDTO = new DrziPredmetDTO( id, nastavnikId, semestarId, predmetId, grupa );

        return drziPredmetDTO;
    }

    private int drziPredmetNastavnikId(DrziPredmet drziPredmet) {
        if ( drziPredmet == null ) {
            return 0;
        }
        Nastavnik nastavnik = drziPredmet.getNastavnik();
        if ( nastavnik == null ) {
            return 0;
        }
        int id = nastavnik.getId();
        return id;
    }

    private int drziPredmetSemestarId(DrziPredmet drziPredmet) {
        if ( drziPredmet == null ) {
            return 0;
        }
        Semestar semestar = drziPredmet.getSemestar();
        if ( semestar == null ) {
            return 0;
        }
        int id = semestar.getId();
        return id;
    }

    private int drziPredmetPredmetId(DrziPredmet drziPredmet) {
        if ( drziPredmet == null ) {
            return 0;
        }
        Predmet predmet = drziPredmet.getPredmet();
        if ( predmet == null ) {
            return 0;
        }
        int id = predmet.getId();
        return id;
    }
}
