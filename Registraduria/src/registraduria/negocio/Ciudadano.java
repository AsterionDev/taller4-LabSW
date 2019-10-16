package registraduria.negocio;

import java.util.Date;

/**
 *
 * @author libardo
 */
public class Ciudadano {

    private String cedula;
    private String nom;
    private String ape;
    private String direccion;
    private String movil;
    private String email;
    private String sexo;
    private Date fechaNac;

    public Ciudadano(String cedula, String nombres, String apellidos, String direccion, String movil, String email, String sexo, Date fecNac) {
        this.cedula = cedula;
        this.nom = nombres;
        this.ape = apellidos;
        this.direccion = direccion;
        this.movil = movil;
        this.email = email;
        this.sexo = sexo;
        this.fechaNac = fecNac;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String id) {
        this.cedula = id;
    }

    public String getNombres() {
        return nom;
    }

    public void setNombres(String nombres) {
        this.nom = nombres;
    }

    public String getApellidos() {
        return ape;
    }

    public void setApellidos(String apellidos) {
        this.ape = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String celular) {
        this.movil = celular;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date edad) {
        this.fechaNac = edad;
    }

}
