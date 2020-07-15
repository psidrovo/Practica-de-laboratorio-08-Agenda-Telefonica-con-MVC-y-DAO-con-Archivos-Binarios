
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public interface ITelefono {
    public void create(Telefono telefono);
    public Telefono read(int codigo);
    public void update(Telefono telefono);
    public void delete(int codigo);   
    public List<Telefono> todosTelefonos();
    public int getCodigoActual();
}
