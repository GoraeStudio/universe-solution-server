package my.gorae.appUniverseServer.transportation.bus.entity.busType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;
import my.gorae.appUniverseServer.transportation.timetable.entity.TimetableEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TimetableTypeBus extends BusEntity {
    // 시간표로 움직이는 차량
    private Integer prevDepartureTime; // 최근 출발 시간
    private Integer nextDepartureTime; // 다음 출발 시간
    private Integer timeSincePrevDeparture; // 최근 출발 시간으로부터 경과시간
    private Integer timeBeforeNextDeparture; // 다음 출발까지 남은 시간

    @OneToMany(mappedBy = "timetableTypeBus")
    private List<TimetableEntity> timetables = new ArrayList<>();
}
