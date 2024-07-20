package nova.estado.adapter.out.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado_reporte")
public class EstadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

}