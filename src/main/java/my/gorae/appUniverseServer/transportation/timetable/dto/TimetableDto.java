package my.gorae.appUniverseServer.transportation.timetable.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import my.gorae.appUniverseServer.common.BaseDto;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class TimetableDto extends BaseDto{
    private Long id;
    private String DayCode; // 시간표 요일 0,1,2,3,4,5,6,7 (월,화,수,목,금,토,일,공휴일) ,로 구분
    private LocalDateTime applyStartAt;
    private LocalDateTime applyEndAt;
    private LocalTime frequentOperationStartAt; // 운행 시작 시간 (시간만 저장)
    private LocalTime frequentOperationEndAt; // 운행 종료 시간 (시간만 저장)
    private String jsonTimetable;
}
