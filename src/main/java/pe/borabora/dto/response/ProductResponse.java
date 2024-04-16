package pe.borabora.dto.response;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id_product;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private LocalDate expirationDate;
    private String image;
    private Integer categoryId; // Cambiado de categoryId a categoryName
    private String categoryName; // Cambiado de categoryId a categoryName
    private String brandProductName; // Cambiado de brandProductId a brandProductName
    private Boolean deleted;

}