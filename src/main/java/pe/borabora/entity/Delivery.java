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
@NoArgsConstructor
@Data
public class Delivery implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_delivery;

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

    @ManyToOne
    @JoinColumn(name = "type_order_id")
    private TypeOrder order;


}
