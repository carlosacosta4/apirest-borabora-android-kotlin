package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_district;

    @Column(name = "district", nullable = false)
    private String district;

    @OneToMany(mappedBy = "district")
    private Collection<Delivery> deliveries = new ArrayList<>();
}
