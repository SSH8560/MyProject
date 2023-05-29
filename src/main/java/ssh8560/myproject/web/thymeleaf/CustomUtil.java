package ssh8560.myproject.web.thymeleaf;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class CustomUtil {
    public static boolean isToday(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();

        return (date.getYear() == now.getYear()) && (date.getDayOfMonth() == now.getDayOfMonth());
    }

    public static boolean isThisYear(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();

        return now.getYear() == date.getYear();
    }

    public static String dateFormat(LocalDateTime localDateTime, String pattern){
        return localDateTime.format( DateTimeFormatter.ofPattern(pattern));
    }
}
