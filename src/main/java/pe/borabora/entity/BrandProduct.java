package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_brand_product;

    @Column(name = "brand_product")
    private String brand_product;

    @OneToMany(mappedBy = "brandproduct")
    private Collection<Product> products = new ArrayList<>();

}
