package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnimeService {
    public List<Anime> findAll(){
        return List.of(new Anime(1L,"Naruto"), new Anime(2L,"DBZ"));
    }
}
