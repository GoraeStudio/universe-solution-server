package my.gorae.appUniverseServer.transportation.timetable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import my.gorae.appUniverseServer.common.BaseEntity;
import my.gorae.appUniverseServer.transportation.bus.busType.TimetableTypeBus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class TimetableEntity extends BaseEntity {
    @Id
    private Long id;
    private String DayCode; // 시간표 요일 0,1,2,3,4,5,6,7 (월,화,수,목,금,토,일,공휴일) ,로 구분
    private LocalDateTime applyStartAt;
    private LocalDateTime applyEndAt;
    private LocalTime frequentOperationStartAt; // 운행 시작 시간 (시간만 저장)
    private LocalTime frequentOperationEndAt; // 운행 종료 시간 (시간만 저장)

    @ManyToOne
    private TimetableTypeBus timetableTypeBus;
}
