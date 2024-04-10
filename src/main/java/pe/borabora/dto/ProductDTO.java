package pe.borabora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.borabora.entity.Product;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private LocalDate expirationDate;
    private String image;
    private Integer categoryId;
    private Integer brandProductId;
    private Boolean deleted;

    // Constructor que convierte un objeto Product en ProductDTO
    public ProductDTO(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.expirationDate = product.getExpirationDate();
        this.image = product.getImage();
        this.categoryId = product.getCategory().getId_category();
        this.brandProductId = product.getBrandproduct().getCod_brand_product();
        this.deleted = product.isDeleted();
    }
}
