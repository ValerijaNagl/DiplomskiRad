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
@Table(name = "zakljucena")
@AssociationOverrides({
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "STUDENT_ID")),
        @AssociationOverride(name = "pk.semestar",
                joinColumns = @JoinColumn(name = "SEMESTAR_ID"))
})
public class ZakljucenaAnketa implements Serializable {
    @EmbeddedId
    private ZakljucenaAnketaPk pk = new ZakljucenaAnketaPk();

}
