package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pick_up")
public class PickUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pick_up;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "type_order_id")
    private TypeOrder order;

}
