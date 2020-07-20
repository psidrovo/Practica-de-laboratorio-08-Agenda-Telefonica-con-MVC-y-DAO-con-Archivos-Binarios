package ec.edu.ups.modelo;

/**
 *
 * @author Paul Idrovo, Denys Dutan
 */
public class Telefono {
    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;
    private Usuario usuario;
    
    public Telefono() {
    }

    /**
     * Constructores: 
     * 
     * Se instancairon dos constructores un con el constructor vacio y otro 
     * con los atributos de la misma clase.
     * 
     * @param codigo. 
     * @param numero. 
     * @param tipo. 
     * @param operadora.  
     */
    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.codigo = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.operadora = operadora;
    }

    /**
     * Getters y setters
     * 
     * Se crearon los siguientes metodos para conseguir y para establecer los atributos de la clase.
     * 
     */
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash = 37 * hash + this.codigo;
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
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefono{" + "codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + ", usuario=" + usuario + '}';
    }
}
