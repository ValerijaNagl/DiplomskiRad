package servisi.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "student_predmet_semestar")
@AssociationOverrides({
        @AssociationOverride(name = "pk.student",
                joinColumns = @JoinColumn(name = "STUDENT_ID")),
        @AssociationOverride(name = "pk.predmet",
                joinColumns = @JoinColumn(name = "PREDMET_ID")),
        @AssociationOverride(name = "pk.semestar",
                joinColumns = @JoinColumn(name = "SEMESTAR_ID"))
})
public class StudentPredmetSemestar implements Serializable {

    @EmbeddedId
    private StudentPredmetSemestarPk pk = new StudentPredmetSemestarPk();

}
