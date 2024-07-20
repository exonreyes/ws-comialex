package nova.estado.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Estado implements Serializable {
    private Integer id;
    private String nombre;
}
