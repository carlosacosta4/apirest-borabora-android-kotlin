package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pick_up")
@DiscriminatorValue("PICKUP")
public class PickUp extends TypeOrder{

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "cod_headquarter", nullable = false)
    @JsonBackReference("pickup-headquarter")
    private Headquarter headquarter;
}
