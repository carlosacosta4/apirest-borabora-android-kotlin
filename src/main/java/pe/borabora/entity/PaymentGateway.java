package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "payment_gateway")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentGateway implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;

    @Column(name = "trace_number")
    private String trace_number;

    @Column(name = "card_type")
    private Character card_type;

    @Column(name = "card")
    private String card;

    @Column(name = "status")
    private String status;

    @Column(name = "quota_number")
    private String quota_number;

    @Column(name = "transaction_id")
    private String  transaction_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "purchaseNumber")
    private String purchaseNumber;

    @Column(name = "transactionDate")
    private String transactionDate;

    //1 a muchos a Compra
    @OneToMany(mappedBy = "payment")
    private List<Purchase> purchase;
}
