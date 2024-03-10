package pe.borabora.dto;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {

    @NotBlank
	private String name;
	
	@NotBlank
	private String lastname;
	
	@NotBlank
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