package pe.borabora.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    //1:1 delivery

    //1:1 pick up
}
