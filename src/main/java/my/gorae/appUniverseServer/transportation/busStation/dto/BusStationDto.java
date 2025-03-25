package my.gorae.appUniverseServer.transportation.busStation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import my.gorae.appUniverseServer.common.BaseDto;

@SuperBuilder
@NoArgsConstructor
@Getter
public class BusStationDto extends BaseDto {
    private Long id;
    private String name; // 정류소명
    private String description; // 설명
    private float latitude; // 위도
    private float longitude; // 경도
}
