package servisi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
public class ZakljucenaAnketaPk implements Serializable {

    @ManyToOne
    private Semestar semestar;

    @ManyToOne
    private Student student;

    public ZakljucenaAnketaPk() {

    }
}
