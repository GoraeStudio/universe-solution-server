package my.gorae.appUniverseServer.transportation.busStation.controller;

import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.transportation.bus.service.BusService;
import my.gorae.appUniverseServer.transportation.busStation.dto.BusStationDto;
import my.gorae.appUniverseServer.transportation.busStation.service.BusStationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/busStation")
@RequiredArgsConstructor
public class BusStationController {
    private final BusStationService busStationService;

    @PatchMapping("/bus/{busId}/connect")
    public void connectBusStation(@PathVariable Long busId, Long busStationId) {
        busStationService.connectBusStation(busId, busStationId);
    }

    @PatchMapping("/bus/{busId}/disconnect")
    public void disconnectBusStation(@PathVariable Long busId, Long busStationId) {
        busStationService.disconnectBusStation(busId, busStationId);
    }

    @PostMapping
    public void createBusStation(@RequestBody BusStationDto busStationDto) {
        busStationService.createBusStation(busStationDto);
    }

}
