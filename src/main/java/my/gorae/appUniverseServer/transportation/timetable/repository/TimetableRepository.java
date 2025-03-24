package my.gorae.appUniverseServer.transportation.timetable.repository;

import my.gorae.appUniverseServer.transportation.timetable.entity.TimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<TimetableEntity, Long> {
}
