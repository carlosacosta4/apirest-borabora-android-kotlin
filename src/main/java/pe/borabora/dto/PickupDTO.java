package pe.borabora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PickupDTO {
    private String date;
    private Integer codHeadquarter;
}
