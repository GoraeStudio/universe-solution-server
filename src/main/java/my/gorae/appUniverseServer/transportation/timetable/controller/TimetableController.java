package my.gorae.appUniverseServer.transportation.timetable.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.common.response.CommonResponse;
import my.gorae.appUniverseServer.common.response.CommonResponseUtil;
import my.gorae.appUniverseServer.transportation.timetable.dto.TimetableDto;
import my.gorae.appUniverseServer.transportation.timetable.entity.TimetableEntity;
import my.gorae.appUniverseServer.transportation.timetable.service.TimetableService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @PostMapping("/{busId}")
    public void createTimetable(@PathVariable Long busId, @RequestBody TimetableDto timetableDto) throws JsonProcessingException {
        timetableService.createTimetable(busId,timetableDto);
    }

    @GetMapping("/currentInfo/{busId}")
    public CommonResponse<TimetableDto> getCurrentInfo(@PathVariable Long busId) {
        return CommonResponseUtil.success(timetableService.getTimetableEntity(busId));
    }
}
