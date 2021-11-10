package servisi.domain;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pitanje")
public class Pitanje implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Type(type = "text")
    private String tekst;
    private String tip;
    private String format;
}


