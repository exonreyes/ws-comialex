package nova.area.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Reporte implements Serializable {
    private Integer id;
    private String nombre;
}