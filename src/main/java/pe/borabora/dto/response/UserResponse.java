package pe.borabora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	private Integer identityDoc;
    private String name;
    private String lastname;
    private Integer cellphone;
    private String email;
    private String username;

}