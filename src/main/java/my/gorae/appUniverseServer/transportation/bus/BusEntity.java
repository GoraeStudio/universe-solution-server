package my.gorae.appUniverseServer.transportation.bus;

import jakarta.persistence.*;
import my.gorae.appUniverseServer.common.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BusEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeNo; // 노선번호 (노선 식별자 마을버스24번, 셔틀버스 등...)
}
