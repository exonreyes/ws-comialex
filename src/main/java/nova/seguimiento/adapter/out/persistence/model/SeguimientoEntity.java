package nova.seguimiento.adapter.out.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.estado.adapter.out.persistence.model.EstadoEntity;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "seguimiento")
public class SeguimientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguimiento", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "id_ticket", nullable = false)
    private Integer idTicket;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoEntity idEstado;

    @Size(max = 50)
    @Column(name = "agente", length = 50)
    private String agente;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Lob
    @Column(name = "nota")
    private String nota;

}