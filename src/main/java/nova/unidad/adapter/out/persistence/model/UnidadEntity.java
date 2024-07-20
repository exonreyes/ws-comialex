package nova.unidad.adapter.out.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.horario.adapter.out.persistence.model.HorarioEntity;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "unidad")
public class UnidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad", nullable = false)
    private Integer id;

    @Size(max = 10)
    @NotNull
    @Column(name = "clave", nullable = false, length = 10)
    private String clave;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToOne(mappedBy = "unidad")
    private UnidadContactoEntity contacto;

    @OneToMany(mappedBy = "unidad")
    private List<HorarioEntity> horarios;

}