package nova.seguimiento.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nova.estado.domain.model.Estado;
import nova.ticket.domain.model.Ticket;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seguimiento {
private Integer id;
private Ticket ticket;
private String nota;
private Estado estatus;
private String agente;
private String fecha;
}
