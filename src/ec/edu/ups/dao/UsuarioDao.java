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
    private Usuario usuarioDao;
    private int tamanioRegistro;

    public UsuarioDao() {
        try {
            archivo = new RandomAccessFile("datos/usuarios.dat", "rw");
            usuarioDao = new Usuario();
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
        int salto = 116;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                usuarioDao.setCedula(archivo.readUTF());
                usuarioDao.setNombre(archivo.readUTF());
                usuarioDao.setApellido(archivo.readUTF());
                usuarioDao.setCorreo(archivo.readUTF());
                usuarioDao.setContrasena(archivo.readUTF());
                if (credenciales.equals(usuarioDao.getCorreo() + usuarioDao.getContrasena())) {
                    return usuarioDao;
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
                usuarioDao.setCedula(archivo.readUTF());
                if (usuarioControlador.getCedula().equals(usuarioDao.getCedula())) {
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
            System.out.println("Error escritura y lectura [read DAOUsuario]");
        }
    }

    @Override
    public void delete(String credencial) {

    }

}
