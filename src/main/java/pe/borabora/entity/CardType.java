package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_card_type;

    @Column(name = "type",nullable = false)
    private Character type;

    @OneToMany(mappedBy = "card_type", cascade = CascadeType.ALL)
    @JsonManagedReference("cardtype-payment")
    private Collection<PaymentGateway> paymentGateways = new ArrayList<>();
}
