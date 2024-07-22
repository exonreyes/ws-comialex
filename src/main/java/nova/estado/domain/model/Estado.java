package nova.estado.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
public class Estado implements Serializable {
    private Integer id;
    private String nombre;

    public Estado(Integer id) {
        this.id = id;
    }
}
