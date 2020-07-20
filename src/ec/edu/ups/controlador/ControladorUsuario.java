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
 * telefonos disponibles en Telefono Dao.
 * 
 * tambien se instanciaron 2 atributos para el uso de esta clase. 
 *
 * @author Paul Idrovo, Denys Dutan
 */
public class ControladorUsuario {

    private IUsuario usuarioDao;
    private Usuario usuario;

    public ControladorUsuario() {
    }

    /**
     * Constructor ControladorUsuario con valores iniciales. 
     * 
     * Este constructor recibe la vista de Usuairo, el UsuarioDao y el 
     * telefonoDao.
     *
     *
     * @param usuarioDao. 
     * @param telefonoDao.
     */
    public ControladorUsuario(UsuarioDao usuarioDao, TelefonoDao telefonoDao, Usuario usuario) {
        this.usuario = usuario;
        this.usuarioDao = usuarioDao;
    }

    /**
     * Metodo Registrar.
     * 
     * este método recibe todos los atributos de un usuario en su parámetro. 
     * Este método lo que hace es agarrar los atributos en sus parámetros y 
     * sumarle los espacios para que cada usuario tenga un espacio de 178 bits.
     * Por ultimo, instancia un nuevo usuario con los atributos del parámetro
     * y llama al DAO a que cree un nuevo usuario. 
     *
     * @param cedula.
     * @param nombre.
     * @param apellido.
     * @param correo.
     * @param contrasena.
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

        Usuario registroUsuario = new Usuario(cedula, nombre, apellido, correo, contrasena);
        usuarioDao.create(registroUsuario);
    }

    /**
     * Metodo actualizarDatos.
     * 
     * este método recibe todos los atributos de un usuario en su parámetro. 
     * Este método lo que hace es agarrar los atributos en sus parámetros y 
     * sumarle los espacios para que cada usuario tenga un espacio de 178 bits. 
     * Este método llama a los Setters de la clase Usuario y ingresa los datos 
     * directamente en los setters. Por último, llama al DAO a que actualice el
     * usuario con los datos del parámetro.
     * 
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param contrasena 
     */
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

        //Actualizamos los datos
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);
        usuarioDao.update(usuario);
    }

    /**
     * Metodo inicoSesion.
     * 
     *este método recibe en sus parámetros el correo y la contraseña del GUI 
     * VistaIncioSesion. Este método lo que hace primero es completar el tamaño 
     * de los objetos para que puedan compararse con el archivo de datos. 
     * una vez completado eso llama al usuarioDao a que comprueba si existen 
     * esas credenciales. Por último, si es que existe retorna ese usuario si 
     * es que no existe retorna null. 
     *
     * @param correo.
     * @param contrasena.
     * @return usuario.
     */
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
    
    /**
     * Metodo VerUsaurio.
     * 
     * este método solamente retorna el usuario.
     * 
     * @return usuario. 
     */

    public Usuario verUsuario(){
        return usuario;
    }
    
    /**
     * Metodo cargarDatosUsuario
     * 
     * este método recibe en sus parámetros 2 objetos de tipos String. 
     * Primero se instancia un nuevo objeto de tipo Usuario, luego se crea una 
     * condición en la cual pregunta por que tipo de búsqueda se va a encontrar 
     * los datos. si es que es por cedula se llama al usaurioDao.
     * buscarCedula sino se llama a usuariosDao.buscarCorreo. 
     * 
     * @param dato
     * @param tipo
     * @return us.
     */
    public Usuario cargarDatosUsuario(String dato, String tipo){
        Usuario us = new Usuario();
        if (tipo.equals("CEDULA")) {
            us=usuarioDao.buscarCedula(dato);            
        } else {
            for (int i = dato.length(); i < 50; i++) {
                dato += " ";
            }
            dato = dato.substring(0, 50);
            us = usuarioDao.buscarCorreo(dato);
        }
        return us;
    }
}
