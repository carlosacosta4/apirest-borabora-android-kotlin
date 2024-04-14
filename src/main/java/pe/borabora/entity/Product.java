package pe.borabora.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product implements Serializable {
	

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_product; 

    @Column(name = "name", length = 180)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
    @Column(name = "expirationDate")
    private LocalDate expirationDate;

    //ya que almacenará la img en base64 necesita más espacio
    @Column(name = "image", columnDefinition = "LONGTEXT")
    @Lob
    private String image;

    @ManyToOne 
    @JoinColumn(name="id_category",nullable=false)
    @JsonBackReference("id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "cod_brand_product", nullable = false)
    @JsonBackReference("cod_brand_product")
    private BrandProduct brandproduct;

    @ManyToMany(mappedBy = "products")
    private Collection<Purchase> purchases = new ArrayList<>();

    @Column(name = "deleted")
    private boolean deleted;
}

