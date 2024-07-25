package nova.ticket.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nova.area.domain.model.Area;
import nova.area.domain.model.Reporte;
import nova.estado.domain.model.Estado;
import nova.unidad.domain.model.Unidad;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {
    private Integer id;
    @NotNull(message = "No se puede procesar el ticket sin un reporte asociado. Por favor, asegúrate de incluir un reporte válido.")
    private Reporte reporte;
    private Area area;
    private String folio;
    @NotNull(message = "La unidad es obligatoria. Por favor, asegúrate de incluir una unidad válida.")
    private Unidad unidad;
    private Estado estado;
    private String agente;
    private String nota;
    private LocalDateTime fecha;
    private Boolean visible;
}
