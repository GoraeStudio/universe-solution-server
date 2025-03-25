package my.gorae.appUniverseServer.transportation.busStation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import my.gorae.appUniverseServer.common.BaseEntity;
import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;

import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
public class BusStationEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 정류소명
    private String description; // 설명
    private float latitude; // 위도
    private float longitude; // 경도

    @ManyToMany(mappedBy = "busStationEntityList")
    private List<BusEntity> busEntityList;
}
