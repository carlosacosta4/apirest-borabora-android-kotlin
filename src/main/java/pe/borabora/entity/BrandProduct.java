package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference("cod_brand_product")
    private Collection<Product> products = new ArrayList<>();

}
