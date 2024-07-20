package nova.ticket.adapter.out.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import nova.area.adapter.out.persistence.model.ReporteEntity;
import nova.estado.adapter.out.persistence.model.EstadoEntity;
import nova.unidad.adapter.out.persistence.model.UnidadEntity;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_unidad", nullable = false)
    private UnidadEntity unidad;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reporte", nullable = false)
    private ReporteEntity reporte;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoEntity estado;

    @Size(max = 50)
    @NotNull
    @Column(name = "folio", nullable = false, length = 50)
    private String folio;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Size(max = 50)
    @Column(name = "agente", length = 50)
    private String agente;

    @Lob
    @Column(name = "nota")
    private String nota;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "visible", nullable = false)
    private Boolean visible = false;

}