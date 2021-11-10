package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PredmetDTO implements Serializable {
    private final int id;
    private final String naziv;
}
