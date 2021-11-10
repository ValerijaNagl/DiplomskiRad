package servisi.api.model;

import lombok.Data;

@Data
public class PitanjeDTO {
    private final int id;
    private final String tekst;
    private final String tip;
    private final String format;
}
