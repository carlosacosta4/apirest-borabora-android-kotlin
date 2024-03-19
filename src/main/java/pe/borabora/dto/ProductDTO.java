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
    private Integer idProduct;
    private String name;
    private String description;
    private String brand;
    private Double price;
    private Integer stock;
    private LocalDate expirationDate;
    private String image;
    private Integer categoryId;
    private String categoryName;
    private Integer brandProductId;
    private String brandProductName;

    // Constructor que convierte un objeto Product en ProductDTO
    public ProductDTO(Product product) {
        this.idProduct = product.getId_product();
        this.name = product.getName();
        this.description = product.getDescription();
        this.brand = product.getBrand();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.expirationDate = product.getExpirationDate();
        this.image = product.getImage();
        this.categoryId = product.getCategory().getId_category();
        this.categoryName = product.getCategory().getName();
        this.brandProductId = product.getBrandproduct().getCod_brand_product();
        this.brandProductName = product.getBrandproduct().getBrand_product();
    }
}
