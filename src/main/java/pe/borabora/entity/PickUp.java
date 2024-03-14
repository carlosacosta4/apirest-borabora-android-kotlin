package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pick_up")
@DiscriminatorValue("PICKUP")
public class PickUp extends TypeOrder{

    @Column(name = "date")
    private String date;

    public PickUp() {
        this.setType("PICKUP");
    }
}
