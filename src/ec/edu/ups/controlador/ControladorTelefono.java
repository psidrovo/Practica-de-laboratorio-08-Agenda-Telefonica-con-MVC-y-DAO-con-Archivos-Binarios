package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 * Clase ControladorTelefono.
 *
 * Esta clase manejara toda la informacion de los telefonos y ademas tendra
 * acceso a la lista de Telefonos registrados que le pertenece a cada Usuario.
 * se instanciaron 4 atributos para el manejo de esta clase.
 *
 * @author Paul Idrovo, Denys Dutan
 */
public class ControladorTelefono {

    private TelefonoDao telefonoDao;
    private UsuarioDao usuarioDao;
    private Telefono telefono;
    private Usuario usuario;

    public ControladorTelefono() {
    }

    /**
     * Constructor.
     * 
     * Este constructor nos permite crear el controlador telefono y
     * que disponga de vistaTelefono y de TelefonoDao.
     *
     * @param telefonoDao.
     * @param usuario. 
     * @param usuarioDao.
     */
    public ControladorTelefono(TelefonoDao telefonoDao, Usuario usuario, UsuarioDao usuarioDao) {
        this.telefonoDao = telefonoDao;
        this.usuario = usuario;
        this.usuarioDao = usuarioDao;
    }

    /**
     * Metodo crearNuevoTelefono.
     * 
     * este método recibe en sus parámetros todos los atributos de un teléfono.
     * Este método lo que hace es agarrar los atributos en sus parámetros y 
     * sumarle los espacios para que cada teléfono tenga un espacio de 97 bits. 
     * Por último, crea un nuevo teléfono con los datos, lo asigna en el 
     * setUsuario y llama al DAO para que cree el nuevo teléfono. 
     *
     * @param codigo.
     * @param numero.
     * @param tipo.
     * @param operadora.
     */
    public void crearNuevoTelefono(int codigo, String numero, String tipo, String operadora) {
        for (int i = numero.length(); i < 25; i++) {
            numero += " ";
        }
        numero = numero.substring(0, 25);

        for (int i = tipo.length(); i < 25; i++) {
            tipo += " ";
        }
        tipo = tipo.substring(0, 25);

        for (int i = operadora.length(); i < 25; i++) {
            operadora += " ";
        }
        operadora = operadora.substring(0, 25);

        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        telefonoDao.create(telefono);
    }

    /**
     * Metodo verTelefono.
     * 
     * este método recibe en sus parámetros el código del teléfono. 
     * Este método llama al telefonoDao y manda que lea el código del teléfono. 
     * Una vez que encuentra el teléfono lo retorna al GUI. 
     *
     * @param codigo.
     * @return telefono.
     */
    public Telefono verTelefono(int codigo) {
        telefono = telefonoDao.read(codigo);
        return telefono;
    }

    /**
     * Metodo actualizar.
     * 
     * este método recibe en sus parámetros todos los atributos de un teléfono. 
     * Este método lo que hace es agarrar los atributos en sus parámetros y 
     * sumarle los espacios para que cada teléfono tenga un espacio de 97 bits. 
     * Por último, crea un nuevo teléfono con los datos, lo asigna en el 
     * setUsuario y llama al DAO para que cree el nuevo teléfono.
     *
     * @param codigo.
     * @param numero.
     * @param tipo.
     * @param operadora.
     */
    public void actualizar(int codigo, String numero, String tipo, String operadora) {
        for (int i = numero.length(); i < 25; i++) {
            numero += " ";
        }
        numero = numero.substring(0, 25);

        for (int i = tipo.length(); i < 25; i++) {
            tipo += " ";
        }
        tipo = tipo.substring(0, 25);

        for (int i = operadora.length(); i < 25; i++) {
            operadora += " ";
        }
        operadora = operadora.substring(0, 25);

        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        telefonoDao.update(telefono);
    }

    /**
     * Metodo eliminar.
     * 
     * este método recibe en sus parámetros el código de un Teléfono.
     * Este método llama al telfonoDao y manda a eliminar el teléfono con el 
     * código que tiene en sus parámetros.
     *
     * @param codigo.
     */
    public void eliminar(int codigo) {
        telefonoDao.delete(codigo);
    }

    /**
     * Metodo verTelefonos.
     *
     * este método lo que hace es llamar al telefonoDao y que liste todos los 
     * teléfonos que existen dentro de un archivo 
     *
     * @return Lista de Telefonos.
     */
    public List<Telefono> verTelefonosGeneral() {
        return telefonoDao.todosTelefonosGeneral();
    }
    
    /**
     * Metodo verTelefonosUsuario.
     * 
     * Este método lo que hace es llamar la telfonoDao y que liste todos los 
     * teléfonos bajo ese usuario.
     * 
     * @return Lista de Telfonos de un usuario.
     */
    public List<Telefono> verTelefonosUsuario() {
        return telefonoDao.listaTelefonosUsuario(usuario);
    }

    /**
     * Metodo verTelefonosUsuarioBusqueda.
     * 
     * este método recibe en sus parámetros dos objetos de tipo String. 
     * Primero se instancia un nuevo objeto de tipo usuario. Luego se crea una 
     * condición en la cual verifica que tipo de búsqueda Eligio el usuario. 
     * Si es que es un tipo de búsqueda por cedula llama al 
     * telfonoDao.buscarCedula, caso contrario llama al TelefonDao.buscarCorreo.
     * pide al DAO que encuentro ese usuario y retorna la lista de teléfono que 
     * tiene ese usuario.
     * 
     * @param dato.
     * @param tipo.
     * @return Lista de telefonos de un usuario. 
     */
    public List<Telefono> verTelefonosUsuarioBusqueda(String dato, String tipo) {
        Usuario us = new Usuario();
        if (tipo.equals("CEDULA")) {
            us=usuarioDao.buscarCedula(dato);
            return telefonoDao.listaTelefonosUsuario(us);
        } else {
            for (int i = dato.length(); i < 50; i++) {
                dato += " ";
            }
            dato = dato.substring(0, 50);
            us = usuarioDao.buscarCorreo(dato);
            return telefonoDao.listaTelefonosUsuario(us);
        }
    }

    /**
     * Metodo getCodigoSiguiente.
     * 
     * este metodo lo único lo que hace es conseguir el siguiente código para 
     * signarlos al nuevo teléfono que se esta registrando. 
     * 
     * @return codigoSiguiente.
     */
    public int getCodigoSiguiente() {
        int codigoSiguiente = telefonoDao.getCodigoActual() + 1;
        return codigoSiguiente;
    }
}
