package pe.borabora.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
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

    @Column(name = "condominium")
    private Boolean condominium;

    @Column(name = "department", length = 100)
    private String department;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "district", length = 100)
    private String district;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "ubigeo")
    private Integer ubigeo;

    @AssertTrue(message = "Ubigeo number must be 6 digits")
    public boolean isUbigeoValid() {
        return String.valueOf(this.ubigeo).length() == 6;
    }

    @Column(name = "headquarters", length = 80)
    private String headquarters; //sede

    @Column(name = "date")
    private String date;

    //1 delivery por 1 compra
    @OneToOne
    private Purchase purchase;
}
