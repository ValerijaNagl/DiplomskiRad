package servisi.api.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DrziPredmetDTO {
    private int id;
    private int nastavnikId;
    private int semestarId;
    private int predmetId;
    private String grupa;
}
