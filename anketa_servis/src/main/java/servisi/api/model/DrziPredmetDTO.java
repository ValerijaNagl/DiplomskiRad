package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DrziPredmetDTO implements Serializable {
    private final int id;
    private final int nastavnikId;
    private final int semestarId;
    private final int predmetId;
    private final String grupa;
}
