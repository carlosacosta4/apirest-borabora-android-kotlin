package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "orderType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Delivery.class, name = "DELIVERY"),
        @JsonSubTypes.Type(value = PickUp.class, name = "PICKUP")
})
public abstract class TypeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer type_order_id;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    @OneToMany(mappedBy = "order")
    @JsonBackReference("order-purchase")
    private List<Purchase> purchases;
}