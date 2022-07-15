package academy.devdojo.springboot.controller;

import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController // tudo que retornará são strings
@RequestMapping("anime")    // para mapear uma classe
@Log4j2 //para ver os logs na api
public class AnimeController {

    private DateUtil dateUtil;

    public AnimeController(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping("list") //para mapear métodos
    public List<Anime> list(){
        log.info(dateUtil.formatDateTimeToDatabaseStyly(LocalDateTime.now()));  //para ver no meu horario o log
        return List.of(new Anime("Naruto"), new Anime("DBZ"));
    }
}
