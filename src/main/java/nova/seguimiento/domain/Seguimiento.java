package nova.seguimiento.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nova.estado.domain.model.Estado;
import nova.ticket.domain.model.Ticket;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seguimiento implements Serializable {
    private Integer id;
    @NotNull(message = "Se requieire un ticket asociado al seguimiento")
    private Ticket ticket;
    private String nota;
    @NotNull(message = "Se requiere un estatus para el seguimiento")
    private Estado estado;
    private String agente;
    private LocalDateTime fecha;
}
