package my.gorae.appUniverseServer.transportation.bus.dto.busType;

import lombok.Getter;
import lombok.Setter;
import my.gorae.appUniverseServer.common.IDto;
import my.gorae.appUniverseServer.transportation.bus.dto.BusDto;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.ApiTypeBus;

@Getter
@Setter
public class ApiTypeBusDto extends BusDto implements IDto {
    private String nodeId; // 정류소 ID
    private String nodeNm; // 정류소명
    private String routeId; // 노선 ID
    private String routeTp; // 노선유형
    private String vehicleTp; // 도착예정버스 차량유형
    private Integer arrPrevStationCnt; // 도착예정버스 남은 정류장 수
    private Integer arrTimeSec; // 도착예정버스 도착예상시간 (초)

    public ApiTypeBus toEntity() {
        return ApiTypeBus.builder()
                .id(this.getId())
                .routeNo(this.getRouteNo())
                .nodeId(this.getNodeId())
                .nodeNm(this.getNodeNm())
                .routeId(this.getRouteId())
                .routeTp(this.getRouteTp())
                .vehicleTp(this.getVehicleTp())
                .arrPrevStationCnt(this.getArrPrevStationCnt())
                .arrTimeSec(this.getArrTimeSec())
                .build();
    }
}
