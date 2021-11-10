package servisi.api.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OdgovorDTO {
    private Integer id;
    private Integer pitanjeId;
    private Integer studentId;
    private Integer semestarId;
    private String odgovor;
    private Integer drziPredmetIliPredmetId;
}
