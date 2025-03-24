package my.gorae.appUniverseServer.transportation.bus.dto.busType;

import lombok.Getter;
import lombok.Setter;
import my.gorae.appUniverseServer.transportation.bus.dto.BusDto;

@Getter
@Setter
public class TimetableTypeBusDto extends BusDto {
    private Integer prevDepartureTime; // 최근 출발 시간
    private Integer nextDepartureTime; // 다음 출발 시간
    private Integer timeSincePrevDeparture; // 최근 출발 시간으로부터 경과시간
    private Integer timeBeforeNextDeparture; // 다음 출발까지 남은 시간
}
