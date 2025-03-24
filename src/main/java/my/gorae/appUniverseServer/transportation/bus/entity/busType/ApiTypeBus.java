package my.gorae.appUniverseServer.transportation.bus.entity.busType;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;

@AllArgsConstructor
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class ApiTypeBus extends BusEntity {
    private String nodeId; // 정류소 ID
    private String routeId; // 노선 ID
    private String routeTp; // 노선유형
    private String vehicleTp; // 도착예정버스 차량유형
    private Integer arrPrevStationCnt; // 도착예정버스 남은 정류장 수
    private Integer arrTimeSec; // 도착예정버스 도착예상시간 (초)
}
