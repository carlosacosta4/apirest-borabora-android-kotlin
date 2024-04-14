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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_status;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    @JsonManagedReference("payment-status")
    private Collection<PaymentGateway> paymentGateways = new ArrayList<>();

}
