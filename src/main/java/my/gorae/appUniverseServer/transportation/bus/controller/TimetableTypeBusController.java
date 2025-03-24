package my.gorae.appUniverseServer.transportation.bus.controller;

import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.common.response.CommonResponse;
import my.gorae.appUniverseServer.common.response.CommonResponseUtil;
import my.gorae.appUniverseServer.transportation.bus.dto.busType.TimetableTypeBusDto;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.bus.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class TimetableTypeBusController {

    private final BusService busService;

    @GetMapping("/timetableType")
    public CommonResponse<Page<TimetableTypeBus>> getTimetableTypeBusList(Pageable pageable) {
        return CommonResponseUtil.success(busService.getTimetableTypeBusList(pageable));
    }

    @PostMapping("/timetableType")
    public void createTimetableBus(@RequestBody TimetableTypeBusDto timetableTypeBusDto) {
        busService.createTimetableBus(timetableTypeBusDto);
    }
}
