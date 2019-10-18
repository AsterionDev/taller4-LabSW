/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral.negocio;



import java.sql.SQLException;

/**
 * Representa el modelo (Observable) de datos Cuando hay cambios en el estado,
 * notifica a todas sus vistas (observadores)
 *
 * @author Julio, Libardo, Ricardo
 */
public class GestorClientes{

    
    private ConectorJdbc conector;

    public GestorClientes() {
        conector = new ConectorJdbc();
    }

    
    /**
     * agrega un cliente a la base de datos
     *
     * @param id
     * @param nombres
     * @param apellidos
     * @param direccion
     * @param celular
     * @param email
     * @param sexo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void agregarCliente(String id, String nombres, String apellidos, String direccion, String celular, String email, String sexo) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("INSERT INTO Clientes (id, nombres, apellidos, direccion, celular, email, sexo)"
                + " VALUES ("
                + "'" + id + "',"
                + "'" + nombres + "',"
                + "'" + apellidos + "',"
                + "'" + direccion + "',"
                + "'" + celular + "',"
                + "'" + email + "',"
                + "'" + sexo + "'"
                + ")");
        conector.desconectarse();
    }
    public void agregarCliente(Cliente cli) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("INSERT INTO Clientes (id, nombres, apellidos, direccion, celular, email, sexo)"
                + " VALUES ("
                + "'" + cli.getId() + "',"
                + "'" + cli.getNombres() + "',"
                + "'" + cli.getApellidos() + "',"
                + "'" + cli.getApellidos() + "',"
                + "'" + cli.getCelular() + "',"
                + "'" + cli.getEmail() + "',"
                + "'" + cli.getSexo() + "'"
                + ")");
        conector.desconectarse();
    }
    
}
