package my.gorae.appUniverseServer.transportation.timetable.repository;

import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.timetable.entity.TimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimetableRepository extends JpaRepository<TimetableEntity, Long> {
    Optional<TimetableEntity> findByTimetableTypeBus(TimetableTypeBus timetableTypeBus);
}
