package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDTO implements Serializable {
    private final int id;
    private final String username;
    private final String ime;
    private final String prezime;
    private final String smer;
    private final String indeks;
    private final String godinaUpisa;
}
