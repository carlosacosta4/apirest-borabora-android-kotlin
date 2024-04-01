package pe.borabora.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.borabora.entity.RoleEntity;

import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Validated
public class CreateRoleRequest {

    @Size(max = 3, message = "The user cannot have more than 3 roles")
    private List<String> roleListName;

    public CreateRoleRequest(@Size(max = 3, message = "The user cannot have more than 3 roles") List<String> roleListName) {
        this.roleListName = roleListName;
    }
}


