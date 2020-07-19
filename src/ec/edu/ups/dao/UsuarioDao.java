package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuario;
import ec.edu.ups.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Paul Idrovo
 */
public class UsuarioDao implements IUsuario {

    /**
     * Estructura del archivo
     */
    // private String cedula | 10 caracteres (validar cedula).
    // private String nombre | 50 caracteres (llenar con espacios, cortar a 50 caracteres).
    // private String apellido | 50 caracteres(llenar con espacios, cortar a 50 caracteres).
    // private String correo | 50 caracteres (llenar con espacios, cortar a 50 caracteres).
    // private String contrasena | 8 caracteres(validar contraseña) 
    // (string) = 178 bytes + 10 bytes 
    // Total 188
    private RandomAccessFile archivo;
    private Usuario usuarioInterno;
    private int tamanioRegistro;

    public UsuarioDao(Usuario usuario) {
        try {
            archivo = new RandomAccessFile("datos/usuarios.dat", "rw");
            usuarioInterno = usuario;
            tamanioRegistro=188;
        } catch (FileNotFoundException ex) {
            System.out.println("Error escritura y lectura [DaoUsuario]");
            System.out.println(ex);
        }
    }

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
