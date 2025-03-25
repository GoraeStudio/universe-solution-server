package my.gorae.appUniverseServer.transportation.bus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BusDto {
    private Long id;
    private String routeNo; // 노선번호 (노선 식별자 마을버스24번, 셔틀버스 등...)
    private String nodeNm; // 정류소명
    private String description; // 설명
}
