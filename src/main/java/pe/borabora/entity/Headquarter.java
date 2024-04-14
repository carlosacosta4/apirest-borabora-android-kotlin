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
public class Headquarter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_headquarter;

    @Column(name = "headquarter", unique = true)
    private String headquarter;

    @OneToMany(mappedBy = "headquarter")
    @JsonManagedReference("pickup-headquarter")
    private Collection<PickUp> pick = new ArrayList<>();

}
