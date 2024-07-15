package nova.area.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Area implements Serializable {
    private Integer id;
    private String nombre;
    private List<Reporte> reportes;
}