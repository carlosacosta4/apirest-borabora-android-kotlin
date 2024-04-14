package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference("delivery-district")
    private Collection<Delivery> deliveries = new ArrayList<>();
}
