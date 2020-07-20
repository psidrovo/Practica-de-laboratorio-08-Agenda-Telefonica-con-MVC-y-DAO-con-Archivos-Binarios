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
 * @author Paul Idrovo, Denys Dutan
 */
public class TelefonoDao implements ITelefono {

    /**
     * Estructura del archivo telefono
     * 
     * private int codigo (4bytes)
     * private String numero (25 bytes) + 2 extras
     * private String tipo (25 bytes) + 2 extras
     * private String operadora (25 bytes) + 2 extras
     * private Usuario usuario (cedula ID) -> 10 bytes + 2 extras
     * Total 97 bytes
     * 
     * Se instanciaron 7 atributos para esta clase.
     * 
     */
 
    private RandomAccessFile archivo;
    private int codigo;
    private int tamanioRegistro;

    private UsuarioDao usuarioDao;
    private Telefono telefonoInterno;
    private Usuario usuarioInterno;

    private String eliminar25Bytes;
    private String eliminar10Bytes;
    
    /**
     * Constructor.
     * 
     * En este constructor se inizializa el proceso del RandomAccessFile 
     * con su ruta predeterminada. Tambien se inicializan algunos atributos con valores
     * predeterminados para facilitar la interacion de la aplicacion con el archivo. 
     * 
     * @param usuarioDao. 
     */

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
    
    /**
     * Metodo Create.
     * 
     * este método recibe en sus parámetros un objeto de tipo Teléfono. 
     * Este método lo que hace es posicionarse en la ultima posición del archivo y empezar a 
     * crear un nuevo teléfono con los datos que recibe. 
     * 
     * @param telefono. 
     */
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

    /**
     * Metodo Read.
     * 
     * este método recibe en sus parámetros un código de teléfono. 
     * Primero se instancia un entero para que empiece desde la posición inicial 
     * del archivo y con un while recorremos el archivo. Empezamos a saltar de 
     * dato en dato y preguntamos si es que el código que tenemos existe en 
     * archivo de teléfonos, si es que lo encuentra retornamos ese teléfono.
     * 
     * @param codigo.
     * @return telefonoIterno.
     */
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

    /**
     * Metodo update
     * 
     * este método recibe en sus parámetros un objeto de tipo Teléfono. 
     * Primero se instancia un entero para que empiece desde la posición inicial
     * del archivo y con un while recorremos el archivo. Empezamos a saltar de 
     * dato en dato y preguntamos si es que el código que tenemos es igual a el
     * teléfono en el archivo, si es que es similar solamente sobre escribimos 
     * los nuevos datos sobre los datos antiguos.
     * 
     * @param telefonoControlador. 
     */
    @Override
    public void update(Telefono telefonoControlador) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno.setCodigo(archivo.readInt());
                if (telefonoControlador.getCodigo() == telefonoInterno.getCodigo()) {
                    archivo.seek(salto + 4);
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

    /**
     * Metodo delete 
     * 
     * este método recibe en sus parámetros el código de un teléfono. 
     * Primero se instancia un entero para que empiece desde la posición inicial
     * del archivo y con un while recorremos el archivo. Empezamos a saltar de 
     * dato en dato y preguntamos si es que el código que tenemos es igual a el 
     * teléfono en el archivo, si es que es similar mandamos a sobrescribir los 
     * datos con espacios vacíos de esta manera deja de existir el teléfono en 
     * el archivo. 
     * 
     * @param codigo. 
     */
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

    /**
     * Metodo todosTelefonosGeneral.
     * 
     * en este método primero instanciamos un nuevo ArrayList() y un entero para
     * que empiece desde la posición inicial del archivo y con un while 
     * recorremos el archivo. Empezamos a saltar de dato en dato y preguntamos 
     * si es que el código no es igual a 0 entonces extraemos todos los datos de
     * ese teléfono y los agregamos a ArrayList. Por utlimo una vez terminado el
     * while retornamos ese ArrayList que contiene todos los teléfonos del
     * archivo.
     * 
     * @return Lista de telefonos. 
     */
    @Override
    public List<Telefono> todosTelefonosGeneral() {
        List<Telefono> todosLosTelefonos = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno=new Telefono();
                telefonoInterno.setCodigo(archivo.readInt());
                telefonoInterno.setNumero(archivo.readUTF());
                telefonoInterno.setTipo(archivo.readUTF());
                telefonoInterno.setOperadora(archivo.readUTF());
                String cedula = archivo.readUTF();
                if (telefonoInterno.getCodigo() != 0) {
                    telefonoInterno.setUsuario(usuarioDao.buscarCedula(cedula));
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

    /**
     * Metodo getCodigoActual
     * 
     * este método lo que hace es conseguir el ultimo código del archivo y 
     * sumarle un valor mas, por último, retorna ese valor para asignarlo al 
     * siguiente teléfono que se va a registrar. 
     * 
     * @return codigo.
     */
    @Override
    public int getCodigoActual() {
        try {
            codigo=0;
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

    /**
     * Metodo listaTelefonosUsuario
     * 
     * este método recibe en sus parámetros un objeto de tipo Usuario. 
     * Primero instanciamos un nuevo ArrayList() y un entero para que empiece 
     * desde la posición inicial del archivo y con un while recorremos el 
     * archivo. Como sabemos que al momento de crear un teléfono se agrega un 
     * objeto de tipo usuario al teléfono solamente recorremos el archivo y 
     * preguntamos si es que la cedula del usuario que tenemos es igual a la 
     * cedula del usuario en el archivo. Si es que es igual agregamos los datos 
     * del teléfono en el ArrayList, por ultimo, retornamos esa lista con los 
     * datos.
     * 
     * @param usuarioControlador.
     * @return Lista de Telefono del usuario.
     */
    @Override
    public List<Telefono> listaTelefonosUsuario(Usuario usuarioControlador) {
        List<Telefono> todosLosTelefonos = new ArrayList<>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                telefonoInterno=new Telefono();
                telefonoInterno.setCodigo(archivo.readInt());
                telefonoInterno.setNumero(archivo.readUTF());
                telefonoInterno.setTipo(archivo.readUTF());
                telefonoInterno.setOperadora(archivo.readUTF());
                String cedula = archivo.readUTF();
                if (cedula.equals(usuarioControlador.getCedula())) {
                    telefonoInterno.setUsuario(usuarioControlador);
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
