package servisi.api.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SemestarDTO {
    private int id;
    private String tipSemestra;
    private String skolskaGodina;
}
