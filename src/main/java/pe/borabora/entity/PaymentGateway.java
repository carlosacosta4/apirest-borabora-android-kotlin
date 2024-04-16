package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

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

    @Column(name = "amount")
    private Double amount;

    @Column(name = "card")
    private String card;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "quota_number")
    private String quota_number;

    @Column(name = "trace_number")
    private String trace_number;

    @Column(name = "transactionDate")
    private String transactionDate;

    @ManyToOne
    @JoinColumn(name = "cod_card_type", nullable = false)
    @JsonBackReference("cardtype-payment")
    private CardType card_type;

    @ManyToOne
    @JoinColumn(name = "codigo_status", nullable = false)
    @JsonBackReference("payment-status")
    private Status status;
}
