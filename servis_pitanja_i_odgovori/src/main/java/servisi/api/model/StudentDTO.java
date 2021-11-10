package servisi.api.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDTO {
    private int id;
    private String username;
    private String ime;
    private String prezime;
    private String smer;
    private String indeks;
    private String godinaUpisa;

}
