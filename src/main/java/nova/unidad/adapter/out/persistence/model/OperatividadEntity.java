package nova.unidad.adapter.out.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "operatividad")
public class OperatividadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operatividad", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "nombre", length = 30)
    private String nombre;

}