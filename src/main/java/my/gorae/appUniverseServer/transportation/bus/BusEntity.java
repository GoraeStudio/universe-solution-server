package my.gorae.appUniverseServer.transportation.bus;

import jakarta.persistence.*;
import my.gorae.appUniverseServer.common.BaseEntity;
import my.gorae.appUniverseServer.transportation.busStation.BusStationEntity;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BusEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeNo; // 노선번호 (노선 식별자 마을버스24번, 셔틀버스 등...)

    @ManyToMany
    @JoinTable(
            name = "bus_bus_station",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_station_id")
    )
    private List<BusStationEntity> busStationEntityList;
}
