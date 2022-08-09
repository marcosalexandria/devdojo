package academy.devdojo.springboot.controller;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.service.AnimeService;
import academy.devdojo.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController // tudo que retornará são strings
@RequestMapping("animes")    // para mapear uma classe inteira, sempre no plural
@Log4j2 //para ver os logs na api
@RequiredArgsConstructor    //cria um construtor para todos os atributos final, dispensa o @Aurowired
public class AnimeController {

    private final AnimeService animeService;
    private final DateUtil dateUtil;


    @GetMapping //para mapear métodos
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatDateTimeToDatabaseStyly(LocalDateTime.now()));  //para ver no meu horario o log
        return new ResponseEntity<>(animeService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/find") /*http://localhost:8080/animes/find?name=Naruto*/
    public ResponseEntity<List<Anime>> findByName(@RequestParam String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anime> replace(@PathVariable Long id,@RequestBody Anime anime) {
        anime = animeService.replace(id, anime);
        return ResponseEntity.ok().body(anime);
    }
}
