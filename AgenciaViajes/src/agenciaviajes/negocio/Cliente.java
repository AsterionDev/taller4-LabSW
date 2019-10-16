package agenciaviajes.negocio;

/**
 *
 * @author Libardo, Ricardo, Julio Representa un cliente de la agencia de viajes
 * con sus atributos
 *
 */
public class Cliente {

    private String id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String celular;
    private String email;
    private String sexo;

    /**
     * Constructor parametrizado
     *
     * @param id cedula
     * @param nombres los dos nombres
     * @param apellidos los dos apellidos
     * @param direccion direccion donde vive
     * @param celular telefono movil
     * @param email correo electronico
     * @param sexo Género, masculino o femenino
     */
    public Cliente(String id, String nombres, String apellidos, String direccion, String celular, String email, String sexo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
    }

    public Cliente() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
