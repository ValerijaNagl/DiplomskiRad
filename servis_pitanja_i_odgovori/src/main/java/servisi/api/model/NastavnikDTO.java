package servisi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NastavnikDTO {
    private final int id;
    private final String ime;
    private final String prezime;
    private final String tip;
    private final String email;
}
