package pe.borabora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
	
	private Integer compraId;
    private Double total;
    private Double igv;
    private Double subtotal;
    private LocalDate purchaseDate;
    private Integer paymentId;
    private Integer orderId;
    private Integer identityDoc;
    private List<Integer> productIds;
}