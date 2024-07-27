package nova.seguimiento.adapter.out.persistence;

import nova.seguimiento.application.port.out.NuevoSeguimientoPort;
import nova.seguimiento.application.port.out.ObtenerSeguimientosPort;
import nova.seguimiento.domain.Seguimiento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeguimientoPersistenceAdapter implements ObtenerSeguimientosPort, NuevoSeguimientoPort {
    private final SeguimientoJpaRepository jpaRepository;
    private final SeguimientoMapper mapper;

    public SeguimientoPersistenceAdapter(SeguimientoJpaRepository jpaRepository, SeguimientoMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Seguimiento> obtener(Integer idTicket) {
        return mapper.mapSeguimientos(jpaRepository.findByIdTicketOrderByFechaDesc(idTicket));
    }

    @Override
    public boolean registrar(Seguimiento seguimiento) {
        jpaRepository.save(mapper.mapSeguimiento(seguimiento));
        return true;
    }
}