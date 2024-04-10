package pe.borabora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdateRequest {
    private String email;
    private Integer cellphone;
    private Integer identityDoc;
    private String newPassword;
}