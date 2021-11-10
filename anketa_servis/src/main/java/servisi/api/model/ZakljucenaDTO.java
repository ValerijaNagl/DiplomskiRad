package servisi.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZakljucenaDTO implements Serializable {
    private final Integer studentId;
    private final Integer semestarId;
}
