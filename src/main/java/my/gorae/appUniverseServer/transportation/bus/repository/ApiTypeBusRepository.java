package my.gorae.appUniverseServer.transportation.bus.repository;

import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.ApiTypeBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiTypeBusRepository extends JpaRepository<ApiTypeBus, Long> {
    @Modifying
    @Query("UPDATE ApiTypeBus a SET a.arrPrevStationCnt = null, a.arrTimeSec = null")
    void resetAllApiBusInfo();

    Optional<ApiTypeBus> findApiTypeBusByRouteNoAndNodeNm(String routeNo, String nodeNm);
}
