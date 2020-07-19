
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;

/**
 *
 * @author Paul Idrovo
 */
public interface IUsuario {
    //Métodos CRUD
    public void create(Usuario usuario);
    public Usuario read(String credenciales);
    public void update(Usuario usuario);
    public Usuario buscarCedula(String cedula);
    public Usuario buscarCorreo(String correo);
}
