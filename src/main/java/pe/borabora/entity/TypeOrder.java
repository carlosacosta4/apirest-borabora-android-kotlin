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
    private Integer type_order_id;

    @Column(name = "type")
    private String type;
}
