
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Paul Idrovo, Denys Dutan
 */
public interface ITelefono {
    /**
     * Metodo Create
     * 
     * Este metodo recibe un objeto de tipo Telefono en su parametro.
     * @param telefono. 
     */
    public void create(Telefono telefono);
    /**
     * Metodo read
     * 
     * Este metodo recibe un objeto de tipo int en su parametro.
     * @param codigo.
     * @return Telfono.
     */
    public Telefono read(int codigo);
    /**
     * Metodo update
     * 
     *  Este metodo recibe un objeto de tipo Telefono en su parametro.
     * @param telefono. 
     */
    public void update(Telefono telefono);
    /**
     * Metodo delete
     * 
     * Este metodo recibe un objeto de tipo int en su parametro.
     * @param codigo. 
     */
    public void delete(int codigo); 
    /**
     * Metodo listaTelefonosUsuario
     * 
     * Este metodo recibe un objeto de tipo Usuario en su parametro.
     * @param usuarioControlador.
     * @return ListTelefono. 
     */
    public List<Telefono> listaTelefonosUsuario(Usuario usuarioControlador); 
    /**
     * Metodo todosTelefonosGeneral
     * 
     * Este metodo lista todo los telefonos registrados. 
     * @return ListTelefonos. 
     */
    public List<Telefono> todosTelefonosGeneral();
    /**
     * Metodo getCodigoActual
     * 
     * este metodo consigue el numero de telefono que existen
     * @return codigo. 
     */
    public int getCodigoActual();

}
