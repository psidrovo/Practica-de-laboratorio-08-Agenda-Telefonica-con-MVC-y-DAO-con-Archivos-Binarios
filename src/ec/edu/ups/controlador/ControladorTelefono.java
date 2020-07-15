
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 * Clase ControladorTelefono. 
 * 
 * Esta clase manejara toda la informacion de los telefonos y ademas tendra acceso
 * a la lista de Telefonos registrados que le pertenece a cada Usuario.
 * 
 * @author Paul Idrovo
 */
public class ControladorTelefono {

    private TelefonoDao telefonoDao;
    private Telefono telefono;
    private Usuario usuario;
    
    public ControladorTelefono() {
    }
    /**
     * Constructor.Este constructor nos permite crear el controlador telefono y que disponga
 de vistaTelefono y de TelefonoDao
     * 
     * 
     * @param usuario
     * @param telefonoDao 
     */
    public ControladorTelefono(TelefonoDao telefonoDao, Usuario usuario) {   
        this.telefonoDao=telefonoDao;
        this.usuario=usuario;
    }
    
    /**
     * Metodo crearNuevoTelefono.Este metodo nos ayuda a crear un nuevo telefono y agregarlo
 a la lista general
     * 
     *
     * @param codigo 
     * @param numero 
     * @param tipo 
     * @param operadora 
     */
    public void crearNuevoTelefono(int codigo, String numero, String tipo, String operadora) {
        telefono=new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        telefonoDao.create(telefono);        
    }

    /**
     * Metodo verTelefono.Este metodo nos imprime el telefno con el codigo que le pasamos
     * 
     *
     * @param codigo 
     * @return  
     */
    public Telefono verTelefono(int codigo) {
        telefono = telefonoDao.read(codigo);
        return telefono;
    }

    /**
     * Metodo actualizar.Este metodo lo que hace es actualizar nuestra lista de telefonos.
     * 
     *
     * @param codigo 
     * @param numero 
     * @param tipo 
     * @param operadora 
     */
    
    public void actualizar(int codigo, String numero, String tipo, String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        telefonoDao.update(telefono);
    }
    
    /**
     * Metodo eliminar.Este metodo es llamada para eliminar un telefono del directorio.
     * 
     * @param codigo
     */
    public void eliminar(int codigo) {
        telefonoDao.delete(codigo);
    }

    /**
     * Metodo verTelefonos.
     * 
     * Este metodo nos ayuda a imprimir la lista de telefonos.
     *
     * @return List Telefono
     */
    public List<Telefono> verTelefonosGeneral() {
        return telefonoDao.todosTelefonosGeneral();
    }
    
    public List<Telefono> verTelefonosUsuario() {
        return telefonoDao.listaTelefonosUsuario(usuario);
    }

    public int getCodigoSiguiente(){
        int codigoSiguiente = telefonoDao.getCodigoActual()+1;
        return codigoSiguiente;
    }
}
