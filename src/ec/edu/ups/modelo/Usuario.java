package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author Paul Idrovo, Denys Dutan
 * 
 * En esta clase se instanciaron 5 atributos para poder registrar a un usuario.
 * 
 */
public class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    
    public Usuario() {
    }
    /**
     * Constructores. 
     * 
     * Se instancairon dos constructores un con el constructor vacio y otro 
     * con los atributos de la misma clase.
     * 
     * @param cedula.
     * @param nombre. 
     * @param apellido. 
     * @param correo. 
     * @param contrasena. 
     */
    public Usuario(String cedula, String nombre, String apellido, String correo, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    /**
     * Getters y setters
     * 
     * Se crearon los siguientes metodos para conseguir y para establecer los atributos de la clase. 
     */
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void actualizarDatos (String nombre, String apellido, String correo) {
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
    }
    
    /**
     * Hash code, Equals y ToString 
     *  
     * Estos metodos lo que hacen es dar un valor unico a un atributo de esta clase.
     * 
     */
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.correo);
        hash = 37 * hash + Objects.hashCode(this.contrasena);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }
    
}
