package my.gorae.appUniverseServer.transportation.bus.controller;

import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.common.response.CommonResponse;
import my.gorae.appUniverseServer.common.response.CommonResponseUtil;
import my.gorae.appUniverseServer.transportation.bus.dto.busType.ApiTypeBusDto;
import my.gorae.appUniverseServer.transportation.bus.entity.busType.ApiTypeBus;
import my.gorae.appUniverseServer.transportation.bus.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus/apiType")
@RequiredArgsConstructor
public class ApiTypeBusController {

    private final BusService busService;

    @GetMapping
    public CommonResponse<Page<ApiTypeBus>> getApiTypeBusList(Pageable pageable) {
        return CommonResponseUtil.success(busService.getApiTypeBusList(pageable));
    }
    @PutMapping("/resetApiTypeBusInfo")
    public void resetApiTypeBusInfo() {
        busService.resetAllApiBusInfo();
    }

    @PatchMapping("/api/bus/{routeNo}/station/{nodeNm}")
    public void updateOrCreateApiBusInfo(
            @PathVariable String routeNo,
            @PathVariable String nodeNm,
            @RequestBody ApiTypeBusDto apiTypeBusDto) {
        busService.updateOrCreateApiBusInfo(routeNo, nodeNm,
                apiTypeBusDto.getNodeId(), apiTypeBusDto.getRouteId(),
                apiTypeBusDto.getRouteTp(),apiTypeBusDto.getVehicleTp(),
                apiTypeBusDto.getArrPrevStationCnt(), apiTypeBusDto.getArrTimeSec());
    }

}
