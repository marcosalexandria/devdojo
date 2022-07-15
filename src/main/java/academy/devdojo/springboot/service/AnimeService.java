package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class AnimeService {
    List<Anime> list = List.of(new Anime(1L,"Naruto"), new Anime(2L,"DBZ"));
    public List<Anime> findAll(){
        return list;
    }

    public Anime findById(long id){
        return list.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not fund"));
    }
}
