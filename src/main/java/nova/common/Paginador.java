package nova.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paginador {
    private int pagina, filas, paginas;
    private long totalRegistros;

    public Paginador(int pagina, int filas) {
        this.pagina = pagina;
        this.filas = filas;
    }
}

