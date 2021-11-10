package servisi.domain;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "odgovor_fakultet")
public class OdgovorFakultet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Nullable
    private int studentId;
    private int semestarId;
    @ManyToOne
    @JoinColumn(name="pitanje_id", unique = false)
    private Pitanje pitanje;
    private String odgovor;




}
