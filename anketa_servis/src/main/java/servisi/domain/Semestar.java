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
@Table(name = "semestar")
public class Semestar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipSemestra;
    private String skolskaGodina;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.semestar")
//    private Set<StudentPredmetSemestar> predmetiISemestri = new HashSet<>();

//    @ManyToMany(mappedBy = "semestar", cascade = { CascadeType.REFRESH })
//    @JsonIgnore
//    @ToString.Exclude
//    private List<Student> student;
//
//    @ManyToMany()
//    @JoinTable(
//            name = "student_predmet_semestar",
//            joinColumns = { @JoinColumn(name="semestar_id", referencedColumnName ="id",nullable = true) },
//            inverseJoinColumns = { @JoinColumn(name="predmet_id", referencedColumnName ="id",nullable = true) }
//    )
//    @JsonIgnore
//    @ToString.Exclude
//    private List<Predmet> predmeti;

}
