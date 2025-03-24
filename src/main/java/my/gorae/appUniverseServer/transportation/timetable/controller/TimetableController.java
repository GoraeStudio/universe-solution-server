package my.gorae.appUniverseServer.transportation.timetable.controller;

import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.transportation.timetable.dto.TimetableDto;
import my.gorae.appUniverseServer.transportation.timetable.service.TimetableService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @PostMapping("/{busId}")
    public void createTimetable(@PathVariable Long busId, @RequestBody TimetableDto timetableDto) {
        timetableService.createTimetable(busId,timetableDto);
    }
}
