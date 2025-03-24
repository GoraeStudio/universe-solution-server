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

import java.util.Optional;

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

    @Transactional
    public void resetAllApiBusInfo(){
        apiTypeBusRepository.resetAllApiBusInfo();
    }
    @Transactional
    public void updateOrCreateApiBusInfo(String routeNo, String nodeNm,String nodeId,String routeId,String routeTp ,String vehicleTp , Integer arrPrevStationCnt, Integer arrTimeSec) {
        Optional<ApiTypeBus> optionalApiTypeBus = findApiBusInfo(routeNo, nodeNm);

        ApiTypeBus apiTypeBus = optionalApiTypeBus
                .map(existedApiTypeBus -> updateApiBusInfo(existedApiTypeBus, arrPrevStationCnt, arrTimeSec))
                .orElseGet(() -> createApiBusInfo(routeNo, nodeNm,nodeId,routeId,routeTp,vehicleTp, arrPrevStationCnt, arrTimeSec));

        apiTypeBusRepository.save(apiTypeBus);
    }

    private Optional<ApiTypeBus> findApiBusInfo(String routeNo, String nodeNm) {
        return apiTypeBusRepository.findApiTypeBusByRouteNoAndNodeNm(routeNo, nodeNm);
    }

    private ApiTypeBus updateApiBusInfo(ApiTypeBus existedApiTypeBus, Integer arrPrevStationCnt, Integer arrTimeSec) {
        return existedApiTypeBus.toBuilder()
                .arrPrevStationCnt(arrPrevStationCnt)
                .arrTimeSec(arrTimeSec)
                .build();
    }

    private ApiTypeBus createApiBusInfo(String routeNo, String nodeNm,String nodeId,String routeId,String routeTp,String vehicleTp, Integer arrPrevStationCnt, Integer arrTimeSec) {
        return ApiTypeBus.builder()
                .busTypeEnum(BusTypeEnum.API_TYPE_BUS)
                .routeNo(routeNo)
                .nodeNm(nodeNm)
                .nodeId(nodeId)
                .routeId(routeId)
                .routeTp(routeTp)
                .vehicleTp(vehicleTp)
                .arrPrevStationCnt(arrPrevStationCnt)
                .arrTimeSec(arrTimeSec)
                .build();
    }
    @Transactional
    public void deleteTimetableBus(Long id) {
        timetableTypeBusRepository.deleteById(id);
    }
    @Transactional
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

}
