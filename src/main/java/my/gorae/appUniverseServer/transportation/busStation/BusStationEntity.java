package my.gorae.appUniverseServer.transportation.busStation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import my.gorae.appUniverseServer.common.BaseEntity;

@Entity
public class BusStationEntity extends BaseEntity {

    @Id
    private Long id;

    private String busStationName; // 정류소명
    private float latitude; // 위도
    private float longitude; // 경도

}
