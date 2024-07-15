package nova.unidad.adapter.out.persistence.projection;

public interface UnidadContactoInfo {
    Integer getId();

    ContactoInfo getContacto();

    interface ContactoInfo {
        Integer getId();

        String getDireccion();

        String getTelefono();

        String getEstado();
    }
}