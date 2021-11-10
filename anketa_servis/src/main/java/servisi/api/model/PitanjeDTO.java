package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PitanjeDTO implements Serializable {
    private final int id;
    private final String tekst;
    private final String tip;
    private final String format;
}
