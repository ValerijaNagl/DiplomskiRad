package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class NastavnikDTO implements Serializable {
    private final int id;
    private final String ime;
    private final String prezime;
    private final String tip;
    private final String email;
}
