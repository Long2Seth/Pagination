package co.istad.testapi.feature.dto;

import lombok.Builder;
import org.springframework.data.annotation.Id;


@Builder
public record ProductResponse (

        @Id
        String id,
        String name,
        String description,
        double price,
        int quantity
) {
}
