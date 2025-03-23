package my.gorae.appUniverseServer.transportation.bus.repository;

import my.gorae.appUniverseServer.transportation.bus.entity.busType.ApiTypeBus;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableTypeBusRepository extends JpaRepository<TimetableTypeBus, Long> {
}
