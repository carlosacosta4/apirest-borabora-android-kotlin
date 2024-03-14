package pe.borabora.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@Data
@Table(name = "delivery")
@DiscriminatorValue("DELIVERY")
public class Delivery extends TypeOrder {

    @Column(name = "address", length = 200)
    private String address;
    
    @Column(name = "date")
    private String date;

    @Column(name = "department", length = 100)
    private String department;

    @ManyToOne @JoinColumn(name = "cod_district", nullable = false)
    @JsonBackReference("cod_district")
    private District district;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "ubigeo")
    private Integer ubigeo;

    @AssertTrue(message = "Ubigeo number must be 6 digits")
    public boolean isUbigeoValid() {
        return String.valueOf(this.ubigeo).length() == 6;
    }
    public Delivery() {
        setType("DELIVERY");
    }

}
