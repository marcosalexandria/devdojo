package academy.devdojo.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   //gera todos os get e set, toString, hstcode e iquals
@AllArgsConstructor //gera todos os constructores
public class Anime {
    private Long id;
    private String name;
}