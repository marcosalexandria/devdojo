package academy.devdojo.springboot.controller;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.service.AnimeService;
import academy.devdojo.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Anime> list(){
        log.info(dateUtil.formatDateTimeToDatabaseStyly(LocalDateTime.now()));  //para ver no meu horario o log
        return animeService.findAll();
    }
}
