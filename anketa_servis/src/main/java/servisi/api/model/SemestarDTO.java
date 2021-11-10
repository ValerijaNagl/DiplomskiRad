package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SemestarDTO implements Serializable {
    private final int id;
    private final String tipSemestra;
    private final String skolskaGodina;
}
