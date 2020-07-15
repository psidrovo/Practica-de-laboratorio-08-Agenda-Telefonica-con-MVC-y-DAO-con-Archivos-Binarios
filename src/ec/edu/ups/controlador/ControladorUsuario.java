package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.idao.IUsuario;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

/**
 * Clase ControladorUsuario.
 *
 * Esta clase manejara toda la informacion del usuario y ademas tendra acceso a
 * la lista de usuarios registrados que le pertenece a UsuarioDao, esto se debe
 * a que el cosntructor recibe al usuarioDao. Ademas podra hacer uso de los
 * telefonos disponibles en Telefono Dao
 *
 * @author Paul Idrovo
 */
public class ControladorUsuario {

    private IUsuario usuarioDao;
    private Usuario usuario;

    public ControladorUsuario() {
    }

    /**
     * Constructor ControladorUsuario con valores iniciales. Este constrcutor
     * recibe la vista de Usuairo, el UsuarioDao y el telefonoDao.
     *
     * @see UsuarioDao
     * @see TelefonoDao
     *
     * @param usuarioDao - objeto tipo UsuarioDao
     * @param telefonoDao - objeto tipo TelefonoDao
     */
    public ControladorUsuario(UsuarioDao usuarioDao, TelefonoDao telefonoDao, Usuario usuario) {
        this.usuario = usuario;
        this.usuarioDao = usuarioDao;
    }

    /**
     * Metodo Registrar.Este metodo nos ayuda a registrar un usuario, para ello
     * con la vistaUsuario pedimos los datos para armar nuestro usuaario a
     * registrar, de ahi UsuarioDao mediante el metodo registrarUsuario se
     * encarga de guardar dentro del map que tenemos disponible.
     *
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param contrasena
     * @see UsuarioDao
     */
    public void registrar(String cedula, String nombre, String apellido, String correo, String contrasena) {
        for (int i = nombre.length(); i < 50; i++) {
            nombre += " ";
        }
        nombre = nombre.substring(0, 50);

        for (int i = apellido.length(); i < 50; i++) {
            apellido += " ";
        }
        apellido = apellido.substring(0, 50);

        for (int i = correo.length(); i < 50; i++) {
            correo += " ";
        }
        correo = correo.substring(0, 50);

        Usuario registroUsuario = new Usuario(cedula, nombre, apellido, correo, contrasena);
        usuarioDao.create(registroUsuario);
    }

    public void actualizarDatos(String cedula, String nombre, String apellido, String correo, String contrasena) {
        for (int i = nombre.length(); i < 50; i++) {
            nombre += " ";
        }
        nombre = nombre.substring(0, 50);

        for (int i = apellido.length(); i < 50; i++) {
            apellido += " ";
        }
        apellido = apellido.substring(0, 50);

        for (int i = correo.length(); i < 50; i++) {
            correo += " ";
        }
        correo = correo.substring(0, 50);

        //Actualizamos los datos
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);
        usuarioDao.update(usuario);
    }

    /**
     * Metodo inicoSesion.Este metodo se encarga de pedir las credenciales
     * mendiate la vistaUsuario que tiene el metodo iniciarSesionUsuario, este
     * nos devolvera el credencial la misma que es la key del map, esta esta
     * formada del correo y contraseña.Luego por el UsuarioDao comprobamos si
     * existe y este nos va a retornar todo el Usuario, si es null significa que
     * el Usuario no existe o no estan correctas sus credenciales
     *
     *
     * @param correo
     * @param contrasena
     * @return usuario - objeto tipo Usuario
     * @see VistaUsuario
     * @see UsuarioDao
     */
    //llama al DAO para Iniciar sesion
    public Usuario inicioSesion(String correo, String contrasena) {

        for (int i = correo.length(); i < 50; i++) {
            correo += " ";
        }
        usuario = usuarioDao.read(correo + contrasena);
        if (usuario != null) {
            return usuario;
        }
        return null;
    }

    public void actualizarUsuario(String nombre, String apellido, String correo) {
        for (int i = nombre.length(); i < 50; i++) {
            nombre += " ";
        }
        nombre = nombre.substring(0, 50);

        for (int i = apellido.length(); i < 50; i++) {
            apellido += " ";
        }
        apellido = apellido.substring(0, 50);

        for (int i = correo.length(); i < 50; i++) {
            correo += " ";
        }
        correo = correo.substring(0, 50);
        usuario.actualizarDatos(nombre, apellido, correo);
        usuarioDao.update(usuario);
    }

}
