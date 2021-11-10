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
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String ime;
    private String prezime;
    private String smer;
    private String indeks;
    private String godinaUpisa;

//    @ManyToMany()
//    @JoinTable(
//            name = "student_predmet_semestar",
//            joinColumns = { @JoinColumn(name="student_id", referencedColumnName ="id",nullable = true) },
//            inverseJoinColumns = { @JoinColumn(name="semestar_id", referencedColumnName ="id",nullable = true) }
//    )
//    @JsonIgnore
//    @ToString.Exclude
//    private Set<Semestar> semestar = new HashSet<>();
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "student_predmet_semestar",
//            joinColumns = { @JoinColumn(name="student_id", referencedColumnName ="id", nullable = true) },
//            inverseJoinColumns = { @JoinColumn(name="predmet_id", referencedColumnName ="id",nullable = true) }
//    )
//    @JsonIgnore
//    @ToString.Exclude
//    private Set<Predmet> predmet = new HashSet<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.student")
//    private Set<StudentPredmetSemestar> predmetiISemestri = new HashSet<>();


}
