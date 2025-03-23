package my.gorae.appUniverseServer.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class BaseDto {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
