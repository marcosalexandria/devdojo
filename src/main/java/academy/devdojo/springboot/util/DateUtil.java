package academy.devdojo.springboot.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component //componente configurado para injeção de dependencia
public class DateUtil {
    public String formatDateTimeToDatabaseStyly(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(localDateTime);
    }
}
