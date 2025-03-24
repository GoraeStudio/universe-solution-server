package my.gorae.appUniverseServer.transportation.timetable.dto.time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
public class TimeUnit {
    private Integer hour;
    private List<Integer> minutes;
}
