
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.modelo.Telefono;
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
    
    public ControladorTelefono() {
    }
    /**
     * Constructor.
     * 
     * Este constructor nos permite crear el controlador telefono y que disponga
     * de vistaTelefono y de TelefonoDao
     * 
     * @param vistaT
     * @param telefonoDao 
     */
    public ControladorTelefono(TelefonoDao telefonoDao) {   
        this.telefonoDao=telefonoDao;
    }
    
    /**
     * Metodo crearNuevoTelefono.
     * 
     * Este metodo nos ayuda a crear un nuevo telefono y agregarlo
     * a la lista general
     * 
     * @return 
     */
    public void crearNuevoTelefono(int codigo, String numero, String tipo, String operadora) {
        telefono=new Telefono(codigo, numero, tipo, operadora);
        telefonoDao.create(telefono);        
    }

    /**
     * Metodo verTelefono.
     * 
     * Este metodo nos imprime el telefno con el codigo que le pasamos
     * 
     */
    public Telefono verTelefono(int codigo) {
        telefono = telefonoDao.read(codigo);
        return telefono;
    }

    /**
     * Metodo actualizar.
     * 
     * Este metodo lo que hace es actualizar nuestra lista de telefonos.
     * 
     * @return 
     */
    /*
    public void actualizar(int codigo, String numero, String tipo, String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefonoDao.update(telefono);
    }
    */
    /**
     * Metodo eliminar.
     * 
     * Este metodo es llamada para eliminar un telefono del directorio.
     * 
     * @return 
     *//*
    public int eliminar(int codigo) {
        //telefono = vistaTelefono.eliminarTelefono();
        telefonoDao.delete(codigo);
        return telefono.getCodigo();
    }
*/
    /**
     * Metodo verTelefonos.
     * 
     * Este metodo nos ayuda a imprimir la lista de telefonos.
     */
    public List<Telefono> verTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonoDao.todosTelefonos();
        return telefonos;
    }

    public int getCodigoSiguiente(){
        int codigoSiguiente = telefonoDao.getCodigoActual()+1;
        return codigoSiguiente;
    }
}
