package my.gorae.appUniverseServer.transportation.bus.busType;

import jakarta.persistence.Entity;
import my.gorae.appUniverseServer.transportation.bus.BusEntity;

@Entity
public class ApiTypeBus extends BusEntity {
    private String nodeId; // 정류소 ID
    private String nodeNm; // 정류소명
    private String routeId; // 노선 ID
    private String routeTp; // 노선유형
    private String vehicleTp; // 도착예정버스 차량유형
    private Integer arrPrevStationCnt; // 도착예정버스 남은 정류장 수
    private Integer arrTimeSec; // 도착예정버스 도착예상시간 (초)


}
