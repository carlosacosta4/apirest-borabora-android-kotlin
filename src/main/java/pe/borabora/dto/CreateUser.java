package pe.borabora.dto;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {

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
	private String username ;
	
	@NotBlank
	private String password ;
	
    private Set<String> roles;
}