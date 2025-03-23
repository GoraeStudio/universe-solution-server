package my.gorae.appUniverseServer.transportation.bus.dto;

import lombok.Getter;
import lombok.Setter;
import my.gorae.appUniverseServer.transportation.busStation.BusStationEntity;

import java.util.List;

@Getter
@Setter
public abstract class BusDto {
    private Long id;
    private String routeNo; // 노선번호 (노선 식별자 마을버스24번, 셔틀버스 등...)
}
