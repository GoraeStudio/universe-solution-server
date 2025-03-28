package my.gorae.appUniverseServer.transportation.bus.controller;

import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.common.response.CommonResponse;
import my.gorae.appUniverseServer.common.response.CommonResponseUtil;
import my.gorae.appUniverseServer.transportation.bus.dto.busType.TimetableTypeBusDto;
import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.ApiTypeBus;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.TimetableTypeBus;
import my.gorae.appUniverseServer.transportation.bus.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @GetMapping
    public CommonResponse<Page<BusEntity>> getAllBusList(Pageable pageable) {
        return CommonResponseUtil.success(busService.getBusList(pageable));
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
    }

}
