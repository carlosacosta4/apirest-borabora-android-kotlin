package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase implements Serializable { //compra
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchase_id;

    @Column
    private Double total;

    @Column
    private Double igv;

    @Column
    private Double subtotal;

    @DateTimeFormat(pattern="yyyy-MM-dd",iso= DateTimeFormat.ISO.DATE)
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "identity_doc", nullable = false)
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id" ,nullable = false)
    private PaymentGateway payment;

    @OneToMany(mappedBy = "purchase")
    @JsonManagedReference("purchase_product")
    private Collection<PurchaseProduct> purchaseProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "type_order_id")
    private TypeOrder order;

}
