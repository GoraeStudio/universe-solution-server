package my.gorae.appUniverseServer.transportation.bus.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import my.gorae.appUniverseServer.common.BaseEntity;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.BusTypeEnum;
import my.gorae.appUniverseServer.transportation.busStation.entity.BusStationEntity;


import java.util.List;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BusEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeNo; // 노선번호 (노선 식별자 마을버스24번, 셔틀버스 등...)

    private String nodeNm; // 정류소명

    private String description; // 설명

    @ManyToMany
    @JoinTable(
            name = "bus_bus_station",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_station_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"bus_id", "bus_station_id"})
    )
    private List<BusStationEntity> busStationEntityList;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BusTypeEnum busTypeEnum; // 버스 유형
}
