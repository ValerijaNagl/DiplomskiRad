package servisi.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "drzi_predmet")
public class DrziPredmet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="nastavnik_id")
    private Nastavnik nastavnik;
    @ManyToOne
    @JoinColumn(name="semestar_id")
    private Semestar semestar;
    @ManyToOne
    @JoinColumn(name="predmet_id")
    private Predmet predmet;

    private String grupa;
}


