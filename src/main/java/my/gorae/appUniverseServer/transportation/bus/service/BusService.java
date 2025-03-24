package my.gorae.appUniverseServer.transportation.bus.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.transportation.bus.dto.busType.TimetableTypeBusDto;
import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.ApiTypeBus;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.BusTypeEnum;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.bus.repository.ApiTypeBusRepository;
import my.gorae.appUniverseServer.transportation.bus.repository.BusRepository;
import my.gorae.appUniverseServer.transportation.bus.repository.TimetableTypeBusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusService {

    private final ApiTypeBusRepository apiTypeBusRepository;
    private final TimetableTypeBusRepository timetableTypeBusRepository;
    private final BusRepository busRepository;

    public Page<BusEntity> getBusList(Pageable pageable) {
        return busRepository.findAll(pageable);
    }
    public Page<ApiTypeBus> getApiTypeBusList(Pageable pageable) {
        return apiTypeBusRepository.findAll(pageable);
    }
    public Page<TimetableTypeBus> getTimetableTypeBusList(Pageable pageable) {
        return timetableTypeBusRepository.findAll(pageable);
    }

    public void createTimetableBus(TimetableTypeBusDto timetableTypeBusDto) {

        TimetableTypeBus i = TimetableTypeBus.builder()
                .busTypeEnum(BusTypeEnum.TIMETABLE_TYPE_BUS)
                .routeNo(timetableTypeBusDto.getRouteNo())
                .description(timetableTypeBusDto.getDescription())
                .nodeNm(timetableTypeBusDto.getNodeNm())
                .nextDepartureTime(timetableTypeBusDto.getNextDepartureTime())
                        .prevDepartureTime(timetableTypeBusDto.getPrevDepartureTime())
                        .timeBeforeNextDeparture(timetableTypeBusDto.getTimeBeforeNextDeparture())
                        .timeSincePrevDeparture(timetableTypeBusDto.getTimeSincePrevDeparture())
                        .build();
        timetableTypeBusRepository.save(i);
    }
    public void createApiTypeBus(ApiTypeBus apiTypeBus) {
        apiTypeBusRepository.save(apiTypeBus);
    }
    @Transactional
    public void resetAllApiBusInfo(){
        apiTypeBusRepository.resetAllApiBusInfo();
    }
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

}
