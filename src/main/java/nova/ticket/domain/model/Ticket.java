package nova.ticket.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import nova.area.domain.model.Area;
import nova.area.domain.model.Reporte;
import nova.estado.domain.model.Estado;
import nova.unidad.domain.model.Unidad;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {
    private Integer id;
    private Reporte reporte;
    private Area area;
    private String folio;
    private Unidad unidad;
    private Estado estado;
    private String agente;
    private String nota;
    private LocalDateTime fecha;
}
