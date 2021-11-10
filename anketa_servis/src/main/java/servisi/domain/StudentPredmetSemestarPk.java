package servisi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
public class StudentPredmetSemestarPk implements Serializable {

    @ManyToOne
    private Predmet predmet;

    @ManyToOne
    private Semestar semestar;

    @ManyToOne
    private Student student;

    public StudentPredmetSemestarPk() {

    }
}
