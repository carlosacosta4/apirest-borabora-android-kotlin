package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Table(name = "purchase_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_purchase_product;

    @ManyToOne
    @JoinColumn(name = "purchase_id", nullable = false)
    @JsonBackReference("purchases-purchaseProducts")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @Column
    private int quantity;

}