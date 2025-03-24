package my.gorae.appUniverseServer.transportation.timetable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import my.gorae.appUniverseServer.common.BaseEntity;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.timetable.util.TimetableChecker;

import java.time.LocalDateTime;
import java.time.LocalTime;

@SuperBuilder
@Getter
@NoArgsConstructor
@Entity
public class TimetableEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dayCode; // 시간표 요일 0,1,2,3,4,5,6,7 (월,화,수,목,금,토,일,공휴일) ,로 구분
    private LocalDateTime applyStartAt;
    private LocalDateTime applyEndAt;
    private LocalTime frequentOperationStartAt; // 운행 시작 시간 (시간만 저장)
    private LocalTime frequentOperationEndAt; // 운행 종료 시간 (시간만 저장)

    @ManyToOne
    @JsonIgnore
    private TimetableTypeBus timetableTypeBus;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String jsonTimetable;

    @PrePersist
    @PreUpdate
    private void validateBeforeSave() {
        TimetableChecker.isDayCodeValid(this.jsonTimetable);
        TimetableChecker.isTimetableValid(this.dayCode);
    }



}
