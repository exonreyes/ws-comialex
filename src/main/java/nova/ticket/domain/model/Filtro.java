package nova.ticket.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filtro {
    private Integer idUnidad;
    private Integer idEstado;
    private Integer idArea;
    private Integer pagina;
    private String folio;
    private Integer filas;
    private LocalDateTime desde;
    private LocalDateTime hasta;
}
