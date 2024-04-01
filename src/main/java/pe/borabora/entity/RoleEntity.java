package pe.borabora.entity;

import jakarta.persistence.*;
import lombok.*;
import pe.borabora.model.RoleEnum;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
}
