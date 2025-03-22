package my.gorae.appUniverseServer.transportation.bus.busType;

import jakarta.persistence.Entity;

@Entity
public class TimetableTypeBus extends ApiTypeBus {
    // 시간표로 움직이는 차량
    private Integer prevDepartureTime; // 최근 출발 시간
    private Integer nextDepartureTime; // 다음 출발 시간
    private Integer timeSincePrevDeparture; // 최근 출발 시간으로부터 경과시간
    private Integer timeBeforeNextDeparture; // 다음 출발까지 남은 시간
}
