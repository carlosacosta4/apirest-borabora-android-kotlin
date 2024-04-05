package pe.borabora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandProductDTO {
    private Integer cod_brand_product;
    private String brand_product;
}
