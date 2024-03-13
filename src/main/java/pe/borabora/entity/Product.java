package pe.borabora.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product implements Serializable {
	

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_product; 

    @Column(name = "name", length = 180)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "brand", length = 100)
    private String brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
    @Column(name = "expirationDate")
    private LocalDate expirationDate;

    @Column(name = "image")
    private String image;

    @ManyToOne 
    @JoinColumn(name="id_category",nullable=false)
    @JsonBackReference("id_category")
    private Category category;

}

