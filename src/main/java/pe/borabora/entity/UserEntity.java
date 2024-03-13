package pe.borabora.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Builder
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(unique = true)
	private Integer identity_doc;	

	@NotBlank
	@Column(name = "name", length = 80, nullable = false)
	private String name;
	
	@NotBlank
	@Column(name = "lastname", length = 80, nullable = false)
	private String lastname;

	@NotNull
	@Column(name = "cellphone")
	private Integer cellphone;

	@AssertTrue(message = "Cellphone number must be 9 digits")
	public boolean isCellphoneValid() {
		return String.valueOf(this.cellphone).length() == 9;
	}
	
	@Email
	@NotBlank
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@NotBlank
	@Column(name = "username", length = 100, nullable = false)
	private String username ;
	
	@NotBlank
	@Column(name = "password", nullable = false)
	private String password ;
	
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "identity_doc"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;
	
	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}	
}
