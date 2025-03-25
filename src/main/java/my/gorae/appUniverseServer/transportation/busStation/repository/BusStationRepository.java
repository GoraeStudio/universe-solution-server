package my.gorae.appUniverseServer.transportation.busStation.repository;

import my.gorae.appUniverseServer.transportation.busStation.entity.BusStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStationRepository extends JpaRepository<BusStationEntity, Long> {
}
