package academy.devdojo.springboot.repository;

import academy.devdojo.springboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    public List<Anime> listAll();

}
