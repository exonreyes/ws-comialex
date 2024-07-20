package nova.estado.adapter.out.persistence;

import nova.estado.application.port.out.ObtenerEstadosPort;
import nova.estado.domain.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstadoPersistenceAdapter implements ObtenerEstadosPort {
    private final EstadoJpaRepository jpaRepository;
    private final EstadoMapper mapper;

    @Autowired
    public EstadoPersistenceAdapter(EstadoJpaRepository jpaRepository, EstadoMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Estado> obtenerEstados() {
        return mapper.mapEstados(jpaRepository.findAll());
    }
}
