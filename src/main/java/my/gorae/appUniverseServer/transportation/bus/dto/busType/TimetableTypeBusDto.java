package my.gorae.appUniverseServer.transportation.bus.dto.busType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import my.gorae.appUniverseServer.common.IDto;
import my.gorae.appUniverseServer.transportation.bus.dto.BusDto;
import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.timetable.TimetableEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TimetableTypeBusDto extends BusDto implements IDto {

    private Integer prevDepartureTime; // 최근 출발 시간
    private Integer nextDepartureTime; // 다음 출발 시간
    private Integer timeSincePrevDeparture; // 최근 출발 시간으로부터 경과시간
    private Integer timeBeforeNextDeparture; // 다음 출발까지 남은 시간

    @Override
    public TimetableTypeBus toEntity() {
        return TimetableTypeBus.builder()
                .id(this.getId())
                .routeNo(this.getRouteNo())
                .prevDepartureTime(this.getPrevDepartureTime())
                .nextDepartureTime(this.getNextDepartureTime())
                .timeSincePrevDeparture(this.getTimeSincePrevDeparture())
                .timeBeforeNextDeparture(this.getTimeBeforeNextDeparture())
                .build();
    }
}
