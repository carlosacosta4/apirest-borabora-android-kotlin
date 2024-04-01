package pe.borabora.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;


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
	@Column(name = "username", length = 100, nullable = false, unique = true)
	private String username ;
	
	@NotBlank
	@Column(name = "password", nullable = false)
	private String password ;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;

    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;

    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "identity_doc"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();
}
