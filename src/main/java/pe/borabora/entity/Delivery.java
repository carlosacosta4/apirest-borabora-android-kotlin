package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_delivery;
    private Boolean condominium;
    private String department;
    private String province;
    private String district;
    private String address;
    private Integer ubigeo;
    private String headquarters; //sede
    private String date;

    //1 delivery por 1 compra
    @OneToOne
    private Purchase purchase;
}
