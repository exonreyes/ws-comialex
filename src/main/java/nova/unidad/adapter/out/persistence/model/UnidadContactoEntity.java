package nova.unidad.adapter.out.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "unidad_contacto")
public class UnidadContactoEntity {
    @Id
    @Column(name = "id_unidad", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_unidad", nullable = false)
    private UnidadEntity unidad;

    @Size(max = 15)
    @NotNull
    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Size(max = 255)
    @NotNull
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ColumnDefault("1")
    @Column(name = "estado")
    private Boolean estado;

}