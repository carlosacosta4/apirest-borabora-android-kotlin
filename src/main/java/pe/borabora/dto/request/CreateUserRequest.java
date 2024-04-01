package pe.borabora.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {
    
	@NotNull
    private Integer identity_doc;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotNull
    private Integer cellphone;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Valid
    private CreateRoleRequest roleRequest;
}
