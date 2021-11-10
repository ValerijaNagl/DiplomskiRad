package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OdgovorDTO implements Serializable {
    private final Integer odgovor_id;
    private final Integer pitanje_id;
    private final Integer student_id;
    private final Integer semestar_id;
    private final String odgovor;
    private final Integer drziPredmetIliPredmetId;
}
