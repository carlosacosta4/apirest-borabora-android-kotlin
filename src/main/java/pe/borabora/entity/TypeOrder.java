package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Entity
public abstract class TypeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer type_order_id;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "order")
    private List<Purchase> purchases;
}