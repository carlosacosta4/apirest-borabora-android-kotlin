package pe.borabora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasetResponse {
	
	private Integer purchase_id;
    private Double total;
    private Double igv;
    private Double subtotal;
    private LocalDate purchaseDate;
    private Integer paymentId;
    private String orderType; // Agrega este campo
    private Integer identityDoc;
    private List<Integer> productIds;
}
