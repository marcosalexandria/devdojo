package academy.devdojo.springboot.service;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.exception.BadRequestException;
import academy.devdojo.springboot.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;
    public List<Anime> findAll(){
        return animeRepository.findAll();
    }

    public Anime findById(long id){
        return animeRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not fund"));
    }

    public Anime save(Anime anime) {
        return animeRepository.save(anime);
    }

    public void delete(Long id){
        animeRepository.deleteById(id);
    }

    public Anime replace(Long id, Anime obj) {
        Anime entity = animeRepository.getOne(id);
        entity.setName(obj.getName());
        return animeRepository.save(entity);
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }
}
