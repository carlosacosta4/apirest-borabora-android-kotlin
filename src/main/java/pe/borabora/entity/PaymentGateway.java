package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "payment_gateway")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentGateway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;
    private String trace_number;
    private Character card_type;
    private String card;
    private String status;
    private String quota_number;
    private String  transaction_id;
    private String brand;
    private Double amount;
    private String currency;
    private String purchaseNumber;
    private String transactionDate;

    //1 a muchos a Compra
    @OneToMany(mappedBy = "payment")
    private List<Purchase> purchase;
}
