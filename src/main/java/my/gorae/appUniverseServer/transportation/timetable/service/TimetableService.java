package my.gorae.appUniverseServer.transportation.timetable.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.bus.repository.BusRepository;
import my.gorae.appUniverseServer.transportation.bus.repository.TimetableTypeBusRepository;
import my.gorae.appUniverseServer.transportation.timetable.dto.TimetableDto;
import my.gorae.appUniverseServer.transportation.timetable.dto.time.TimeUnit;
import my.gorae.appUniverseServer.transportation.timetable.entity.TimetableEntity;
import my.gorae.appUniverseServer.transportation.timetable.repository.TimetableRepository;
import my.gorae.appUniverseServer.transportation.timetable.util.TimetableUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;

    private final TimetableTypeBusRepository timetableTypeBusRepository;

    private final ObjectMapper objectMapper;

    public void createTimetable(Long busId,TimetableDto timetableDto) throws JsonProcessingException {
        TimetableTypeBus bus = timetableTypeBusRepository.findById(busId)
                .orElseThrow(() -> new IllegalArgumentException("해당 버스를 찾을 수 없습니다."));

        String jsonTimetable = objectMapper.writeValueAsString(timetableDto.getPojoTimetable());
        TimetableEntity i = TimetableEntity.builder()
                .dayCode(timetableDto.getDayCode())
                .timetableTypeBus(bus)
                .applyStartAt(timetableDto.getApplyStartAt())
                .applyEndAt(timetableDto.getApplyEndAt())
                .frequentOperationStartAt(timetableDto.getFrequentOperationStartAt())
                .frequentOperationEndAt(timetableDto.getFrequentOperationEndAt())
                .jsonTimetable(jsonTimetable)
                .build();

        timetableRepository.save(i);
    }

    public TimetableDto getTimetableEntity(Long busId) {
        TimetableTypeBus bus = timetableTypeBusRepository.findById(busId)
                .orElseThrow(() -> new IllegalArgumentException("해당 버스를 찾을 수 없습니다."));

        Optional<TimetableEntity> t = timetableRepository.findByTimetableTypeBus(bus);

        if (t.isPresent()){
                TimetableEntity timetableEntity = t.get();
                return TimetableDto.builder()
                        .id(timetableEntity.getId())
                        .dayCode(timetableEntity.getDayCode())
                        .applyStartAt(timetableEntity.getApplyStartAt())
                        .applyEndAt(timetableEntity.getApplyEndAt())
                        .frequentOperationStartAt(timetableEntity.getFrequentOperationStartAt())
                        .frequentOperationEndAt(timetableEntity.getFrequentOperationEndAt())
                        .pojoTimetable(TimetableUtils.parseTimetable(timetableEntity.getJsonTimetable()))
                        .build();


        }else {
            throw new IllegalArgumentException("해당 버스의 시간표를 찾을 수 없습니다.");
        }

    }

}
