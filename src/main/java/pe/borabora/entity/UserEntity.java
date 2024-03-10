package pe.borabora.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(unique = true, nullable = false)
	private Integer docIdentidad;

	@Column()
	private String nombres;
	
	@Column()
	private String apellidos;
	
	@Column() 
	private Integer telefono;
	
	@Column()
	private String email;
	
	@Column()
	private String contrasena ;
	

	public UserEntity(String email, String contrasena) {
		super();
		this.email = email;
		this.contrasena = contrasena;
	}	
}
