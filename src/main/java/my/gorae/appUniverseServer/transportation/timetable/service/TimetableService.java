package my.gorae.appUniverseServer.transportation.timetable.service;

import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.bus.repository.BusRepository;
import my.gorae.appUniverseServer.transportation.bus.repository.TimetableTypeBusRepository;
import my.gorae.appUniverseServer.transportation.timetable.dto.TimetableDto;
import my.gorae.appUniverseServer.transportation.timetable.entity.TimetableEntity;
import my.gorae.appUniverseServer.transportation.timetable.repository.TimetableRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;

    private final TimetableTypeBusRepository timetableTypeBusRepository;

    public void createTimetable(Long busId,TimetableDto timetableDto) {
        TimetableTypeBus bus = timetableTypeBusRepository.findById(busId)
                .orElseThrow(() -> new IllegalArgumentException("해당 버스를 찾을 수 없습니다."));

        TimetableEntity i = TimetableEntity.builder()
                .dayCode(timetableDto.getDayCode())
                .timetableTypeBus(bus)
                .applyStartAt(timetableDto.getApplyStartAt())
                .applyEndAt(timetableDto.getApplyEndAt())
                .frequentOperationStartAt(timetableDto.getFrequentOperationStartAt())
                .frequentOperationEndAt(timetableDto.getFrequentOperationEndAt())
                .jsonTimetable(timetableDto.getJsonTimetable())
                .build();

        timetableRepository.save(i);
    }
}
