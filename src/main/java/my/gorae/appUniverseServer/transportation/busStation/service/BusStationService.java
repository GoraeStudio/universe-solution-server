package my.gorae.appUniverseServer.transportation.busStation.service;

import lombok.RequiredArgsConstructor;
import my.gorae.appUniverseServer.transportation.bus.entity.BusEntity;
import my.gorae.appUniverseServer.transportation.bus.repository.BusRepository;
import my.gorae.appUniverseServer.transportation.busStation.dto.BusStationDto;
import my.gorae.appUniverseServer.transportation.busStation.entity.BusStationEntity;
import my.gorae.appUniverseServer.transportation.busStation.repository.BusStationRepository;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BusStationService {
    private final BusStationRepository busStationRepository;
    private final BusRepository busRepository;

    public void connectBusStation(Long busId, Long busStationId) {
        Optional<BusEntity> optionalBusEntity =busRepository.findById(busId);
        Optional<BusStationEntity> optionalBusStationEntity = busStationRepository.findById(busStationId);
        if(optionalBusEntity.isEmpty() || optionalBusStationEntity.isEmpty()){
            throw new IllegalArgumentException("busId or busStationId is not valid");
        }

        BusEntity busEntity = optionalBusEntity.get();
        BusStationEntity busStationEntity = optionalBusStationEntity.get();
        busEntity.getBusStationEntityList().add(busStationEntity);
        busRepository.save(busEntity);

    }

    public void disconnectBusStation(Long busId, Long busStationId) {
        Optional<BusEntity> optionalBusEntity =busRepository.findById(busId);
        Optional<BusStationEntity> optionalBusStationEntity = busStationRepository.findById(busStationId);
        if(optionalBusEntity.isEmpty() || optionalBusStationEntity.isEmpty()){
            throw new IllegalArgumentException("busId or busStationId is not valid");
        }

        BusEntity busEntity = optionalBusEntity.get();
        BusStationEntity busStationEntity = optionalBusStationEntity.get();
        busEntity.getBusStationEntityList().remove(busStationEntity);
        busRepository.save(busEntity);
    }

    public void createBusStation(BusStationDto busStationDto) {
        BusStationEntity i =BusStationEntity.builder()
                .name(busStationDto.getName())
                .description(busStationDto.getDescription())
                .latitude(busStationDto.getLatitude())
                .longitude(busStationDto.getLongitude())
                .build();
        busStationRepository.save(i);
    }

}
