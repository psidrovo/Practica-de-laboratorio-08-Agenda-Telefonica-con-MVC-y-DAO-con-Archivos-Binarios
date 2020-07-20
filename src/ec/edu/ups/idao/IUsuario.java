
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;

/**
 *
 * @author Paul Idrovo, Denys Dutan
 */
public interface IUsuario {
    /**
     * Metodo create
     * 
     * Este metodo recibe un objeto de tipo usuario en su parametro. 
     * @param usuario. 
     */
    public void create(Usuario usuario);
    /**
     * Metodo read
     * 
     * Este metodo recibe un objeto de tipo String en su parametro.  
     * @param credenciales.
     * @return un objeto de tipo Usuario.
     */
    public Usuario read(String credenciales);
    /**
     * Metodo update
     * 
     * Este metodo recibe en objeto de tipo usuario en su parametro.
     * @param usuario. 
     */
    public void update(Usuario usuario);
    /**
     * Metodo buscarCedula
     * 
     * Este metodo recibe en objeto de tipo String en su parametro.
     * @param cedula.
     * @return Usuario.
     */
    public Usuario buscarCedula(String cedula);
    /**
     * Metodo buscarCorreo
     * 
     * Este metodo recibe en objeto de tipo String en su parametro.
     * @param correo.
     * @return Usuario. 
     */
    public Usuario buscarCorreo(String correo);
}
