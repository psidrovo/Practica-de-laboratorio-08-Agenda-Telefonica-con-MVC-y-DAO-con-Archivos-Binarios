package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuario;
import ec.edu.ups.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Paul Idrovo, Denys Dutan
 */
public class UsuarioDao implements IUsuario {

    /**
     * Estructura del archivo
     * private String cedula | 10 caracteres (validar cedula).
     * private String nombre | 50 caracteres (llenar con espacios, cortar a 50 caracteres).
     * private String apellido | 50 caracteres(llenar con espacios, cortar a 50 caracteres).
     * private String correo | 50 caracteres (llenar con espacios, cortar a 50 caracteres).
     * private String contrasena | 8 caracteres(validar contraseña) 
     * (string) = 178 bytes + 10 bytes 
     * Total 178
     * 
     * se instanciaron 3 atributos para esta clase.
     * 
     * 
     */

    private RandomAccessFile archivo;
    private Usuario usuarioInterno;
    private int tamanioRegistro;

    /**
     * Constructor.
     * 
     * En este constructor se inizializa el proceso del RandomAccessFile 
     * con su ruta predeterminada. Tambien se inicializan algunos atributos con valores
     * predeterminados para facilitar la interacion de la aplicacion con el archivo.
     * 
     * @param usuario. 
     */
    public UsuarioDao(Usuario usuario) {
        try {
            archivo = new RandomAccessFile("datos/usuarios.dat", "rw");
            usuarioInterno = usuario;
            tamanioRegistro=178;
        } catch (FileNotFoundException ex) {
            System.out.println("Error escritura y lectura [DaoUsuario]");
            System.out.println(ex);
        }
    }

    /**
     * Metodo Create.
     * 
     * este método recibe en sus parámetros un objeto de tipos Usurario. 
     * Este método lo que hace es posicionarse en la ultima posición del archivo
     * y empieza a crear un nuevo usuario con los datos que tiene. 
     * 
     * @param usuario. 
     */
    @Override
    public void create(Usuario usuario) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreo());
            archivo.writeUTF(usuario.getContrasena());

        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [create DaoUsuario]");
            System.out.println(ex);
        }
    }

    /**
     * Metodo read.
     * 
     * este método recibe en sus parámetros el correo y la contraseña ingresada 
     * por el usuario. Primero se instancia un entero para que empiece desde la 
     * posición inicial del archivo y con un while recorremos el archivo. 
     * Luego preguntamos si es que los datos que ingreso el usuario son igual a 
     * los datos que se encuentran en el archivo. Si es que es similar 
     * retornamos los datos de ese usuario.
     * 
     * @param credenciales.
     * @return usuarioInterno.
     */
    @Override
    public Usuario read(String credenciales) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                usuarioInterno.setCedula(archivo.readUTF());
                usuarioInterno.setNombre(archivo.readUTF());
                usuarioInterno.setApellido(archivo.readUTF());
                usuarioInterno.setCorreo(archivo.readUTF());
                usuarioInterno.setContrasena(archivo.readUTF());
                if (credenciales.equals(usuarioInterno.getCorreo() + usuarioInterno.getContrasena())) {
                    return usuarioInterno;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [read DAOUsuario]");
        }
        return null;
    }

    /**
     * Metodo update
     * 
     * este método recibe en sus parámetros un objeto de tipos usuario. 
     * Primero se instancia un entero para que empiece desde la posición inicial
     * del archivo y con un while recorremos el archivo. En cada recorrido 
     * preguntamos si es que la cedula que ingreso el usuario es similar a la 
     * cedula que se encuentra en el archivo. Si es que es similar empezamos a
     * sobre escribir los nuevos datos sobre los viejos datos.
     * 
     * @param usuarioControlador.
     * 
     */
    @Override
    public void update(Usuario usuarioControlador) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                usuarioInterno.setCedula(archivo.readUTF());
                if (usuarioControlador.getCedula().equals(usuarioInterno.getCedula())) {
                    archivo.seek(salto + 12);
                    archivo.writeUTF(usuarioControlador.getNombre());
                    archivo.writeUTF(usuarioControlador.getApellido());
                    archivo.writeUTF(usuarioControlador.getCorreo());
                    archivo.writeUTF(usuarioControlador.getContrasena());
                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [update DAOUsuario]");
        }
    }


    /**
     * Metodo BuscarCedula
     * 
     * este método recibe en sus parámetros la cedula del usuario. 
     * Primero se instancia un nuevo Usuario y un entero para que empiece desde 
     * la posición inicial del archivo y con un while recorremos el archivo. 
     * Recorremos los usuarios del archivo y preguntamos si es que la cedula 
     * que ingreso usuario es igual a la cedula del archivo. Si es que es igual
     * retornamos es usuario y sus datos.
     * 
     * @param cedula.
     * @return usuarioBusqueda.
     * 
     */
    @Override
    public Usuario buscarCedula(String cedula) {
        Usuario usuarioBusqueda = new Usuario();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                usuarioBusqueda.setCedula(archivo.readUTF());
                usuarioBusqueda.setNombre(archivo.readUTF());
                usuarioBusqueda.setApellido(archivo.readUTF());
                usuarioBusqueda.setCorreo(archivo.readUTF());
                usuarioBusqueda.setContrasena(archivo.readUTF());
                if (cedula.equals(usuarioBusqueda.getCedula())) {
                    return usuarioBusqueda;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [buscarCedula DAOUsuario]");
        }
        return null;
    }
    
    /**
     * Metodo buscarCorreo.
     * 
     * este método recibe en sus parámetros el correo del usuario. 
     * Primero se instancia un nuevo Usuario y un entero para que empiece desde
     * la posición inicial del archivo y con un while recorremos el archivo.
     * Recorremos los usuarios del archivo y preguntamos si es el correo que 
     * ingreso usuario es igual al correo del archivo. Si es que es igual 
     * retornamos es usuario y sus datos. 
     * 
     * @param correo.
     * @return usuarioBusqueda.
     * 
     */
    @Override
    public Usuario buscarCorreo(String correo) {
        Usuario usuarioBusqueda = new Usuario();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                usuarioBusqueda.setCedula(archivo.readUTF());
                usuarioBusqueda.setNombre(archivo.readUTF());
                usuarioBusqueda.setApellido(archivo.readUTF());
                usuarioBusqueda.setCorreo(archivo.readUTF());
                usuarioBusqueda.setContrasena(archivo.readUTF());
                if (correo.equals(usuarioBusqueda.getCorreo())) {
                    return usuarioBusqueda;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [buscarCorreo DAOUsuario]");
        }
        return null;
    }

}
