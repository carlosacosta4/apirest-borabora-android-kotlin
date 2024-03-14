package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TypeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type_order;

    @OneToOne @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    //1:1 pick up
}
