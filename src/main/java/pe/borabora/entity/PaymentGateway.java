package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_card_type", referencedColumnName = "cod_card_type", nullable = false)
    private CardType card_type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_status", referencedColumnName = "codigo_status", nullable = false)
    private Status status;
}
