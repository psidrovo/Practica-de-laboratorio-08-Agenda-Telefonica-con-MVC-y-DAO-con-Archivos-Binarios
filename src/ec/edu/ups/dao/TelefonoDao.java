package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefono;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public class TelefonoDao implements ITelefono {

    /**
     * Estructura del archivo telefono.dat
     */
    // private int codigo (4bytes)
    // private String numero (25 bytes) + 2 extras
    // private String tipo (25 bytes) + 2 extras
    // private String operadora (25 bytes) + 2 extras
    // private Usuario usuario (cedula ID) -> 10 bytes + 2 extras
    // Total 97 bytes
    private RandomAccessFile archivo;
    private int codigo;
    private int tamanioRegistro;

    private UsuarioDao usuarioDao;
    private Telefono telefonoInterno;
    private Usuario usuarioInterno;

    private String eliminar25Bytes;
    private String eliminar10Bytes;

    public TelefonoDao(UsuarioDao usuarioDao) {
        try {
            archivo = new RandomAccessFile("datos/telefono.dat", "rw");
            this.usuarioDao = usuarioDao;
            telefonoInterno = new Telefono();
            tamanioRegistro = 97;
            codigo = 0;
            eliminar25Bytes = "                         ";
            eliminar10Bytes = "          ";
        } catch (FileNotFoundException ex) {
            System.out.println("Error escritura y lectura [DaoTelefono]");
            System.out.println(ex);
        }
    }

    @Override
    public void create(Telefono telefono) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getTipo());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getUsuario().getCedula());

        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [create DaoTelefono]");
            System.out.println(ex);
        }
    }

    @Override
    public Telefono read(int codigo) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno.setCodigo(archivo.readInt());
                telefonoInterno.setNumero(archivo.readUTF());
                telefonoInterno.setOperadora(archivo.readUTF());
                telefonoInterno.setTipo(archivo.readUTF());
                String cedula = archivo.readUTF();
                telefonoInterno.setUsuario(usuarioDao.buscarCedula(cedula));
                if (codigo == telefonoInterno.getCodigo()) {
                    telefonoInterno.setUsuario(usuarioInterno);
                    return telefonoInterno;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [read DAOTelefono]");
        }
        return null;
    }

    @Override
    public void update(Telefono telefonoControlador) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno.setCodigo(archivo.readInt());
                if (telefonoControlador.getCodigo() == telefonoInterno.getCodigo()) {
                    archivo.seek(salto + 4);
                    archivo.write(telefonoControlador.getCodigo());
                    archivo.writeUTF(telefonoControlador.getNumero());
                    archivo.writeUTF(telefonoControlador.getTipo());
                    archivo.writeUTF(telefonoControlador.getOperadora());
                    archivo.writeUTF(telefonoControlador.getUsuario().getCedula());
                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [update DAOTelefono]");
        }
    }

    @Override
    public void delete(int codigo) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno.setCodigo(archivo.readInt());
                if (codigo == telefonoInterno.getCodigo()) {
                    archivo.seek(salto);
                    archivo.write(0);
                    archivo.writeUTF(eliminar25Bytes);
                    archivo.writeUTF(eliminar25Bytes);
                    archivo.writeUTF(eliminar25Bytes);
                    archivo.writeUTF(eliminar10Bytes);
                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [delete DAOTelefono]");
        }
    }

    @Override
    public List<Telefono> todosTelefonosGeneral() {
        List<Telefono> todosLosTelefonos = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno.setCodigo(archivo.readInt());
                telefonoInterno.setNumero(archivo.readUTF());
                telefonoInterno.setTipo(archivo.readUTF());
                telefonoInterno.setOperadora(archivo.readUTF());
                String cedula = archivo.readUTF();
                if (telefonoInterno.getCodigo() != 0) {
                    todosLosTelefonos.add(telefonoInterno);
                }
                salto += tamanioRegistro;
            }
            return todosLosTelefonos;
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [todosTelefonosGeneral DAOTelefono]");
        }
        return null;
    }

    @Override
    public int getCodigoActual() {
        try {
            int tamanioTotal=(int) archivo.length();
            if (archivo.length() > 0) {                
                while(codigo==0){          
                    tamanioTotal-=tamanioRegistro;
                    if(tamanioTotal<0){
                        codigo=0;
                        break;
                    }
                    archivo.seek(tamanioTotal);
                    codigo = archivo.readInt();                    
                }
                    
            }
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [CodigoActual DaoTelefono]");
            System.out.println(ex);
        }
        return codigo;
    }

    @Override
    public List<Telefono> listaTelefonosUsuario(Usuario usuarioControlador) {
        List<Telefono> todosLosTelefonos = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno.setCodigo(archivo.readInt());
                telefonoInterno.setNumero(archivo.readUTF());
                telefonoInterno.setTipo(archivo.readUTF());
                telefonoInterno.setOperadora(archivo.readUTF());
                String cedula = archivo.readUTF();
                if (cedula.equals(usuarioControlador.getCedula())) {
                    todosLosTelefonos.add(telefonoInterno);
                }
                salto += tamanioRegistro;
            }
            return todosLosTelefonos;
        } catch (IOException ex) {
            System.out.println("Error escritura y lectura [listaTelefonosUsuario DAOTelefono]");
            System.out.println(ex);
        }
        return null;
    }

}
