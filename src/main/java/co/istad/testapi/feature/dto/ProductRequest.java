package co.istad.testapi.feature.dto;

public record ProductRequest(

            String name,
            String description,
            double price,
            int quantity
) {
}
