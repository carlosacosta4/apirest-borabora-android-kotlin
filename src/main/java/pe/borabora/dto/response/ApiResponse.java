package pe.borabora.dto.response;

import java.util.Set;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.borabora.entity.RoleEntity;
import pe.borabora.entity.UserEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    
	private String message;
    private int status;

}