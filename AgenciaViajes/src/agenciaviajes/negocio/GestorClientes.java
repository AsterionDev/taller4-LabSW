package agenciaviajes.negocio;

import agenciaviajes.acceso.ServicioRegistraduriaSocket;
import java.util.ArrayList;
import mvcf.AModel;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.Properties;
import agenciaviajes.acceso.IRegistraduria;

/**
 * Representa el modelo (Observable) de datos Cuando hay cambios en el estado,
 * notifica a todas sus vistas (observadores)
 *
 * @author Julio, Libardo, Ricardo
 */
public class GestorClientes extends AModel {

    private final IRegistraduria registraduria;
    private ConectorJdbc conector;

    public GestorClientes() {
        registraduria = new ServicioRegistraduriaSocket();
        conector = new ConectorJdbc();
    }

    /**
     * Trae de la base de datos todos los clientes
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public ArrayList<Cliente> consultarClientes() throws ClassNotFoundException, SQLException {

        conector.conectarse();
        conector.crearConsulta("SELECT * FROM clientes");

        ArrayList<Cliente> clientes = new ArrayList();

        while (conector.getResultado().next()) {
            Cliente cli = new Cliente(conector.getResultado().getString("id"), conector.getResultado().getString("nombres"), conector.getResultado().getString("apellidos"), conector.getResultado().getString("direccion"), conector.getResultado().getString("celular"), conector.getResultado().getString("email"), conector.getResultado().getString("sexo"));
            clientes.add(cli);
        }
        conector.desconectarse();
        return clientes;

    }

    /**
     * Busca un cliente en el servidor remoto de la registraduría
     *
     * @param id identificador del clilente
     * @return Objeto tipo Cliente, null si no lo encuentra
     */
    public Cliente buscarClienteRegistraduria(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = registraduria.obtenerClienteDeLaRegistraduria(id);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            Cliente cliente = new Cliente();
            parseToCliente(cliente, json);
            return cliente;
        }
        return null;
    }

    /**
     * Deserializa el objeto json y lo convierte en un objeto Cliente
     *
     * @param cliente Objeto tipo Cliente
     * @param json objeto cliente en formato json
     */
    private void parseToCliente(Cliente cliente, String json) {
        Gson gson = new Gson();
        Properties properties = gson.fromJson(json, Properties.class);
        cliente.setId(properties.getProperty("id"));
        cliente.setNombres(properties.getProperty("nombres"));
        cliente.setApellidos(properties.getProperty("apellidos"));
        cliente.setDireccion(properties.getProperty("direccion"));
        cliente.setCelular(properties.getProperty("celular"));
        cliente.setEmail(properties.getProperty("email"));
        cliente.setSexo(properties.getProperty("sexo"));

    }

    /**
     * Busca un cliente en la bd de la agencia de viajes
     *
     * @param id identificador del cliente
     * @return Objeto tipo cliente, null si no lo encuentra
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Cliente buscarCliente(String id) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM clientes Where id='" + id + "'");

        Cliente cliente = null;
        if (conector.getResultado().next()) {
            cliente = new Cliente(conector.getResultado().getString("id"), conector.getResultado().getString("nombres"), conector.getResultado().getString("apellidos"), conector.getResultado().getString("direccion"), conector.getResultado().getString("celular"), conector.getResultado().getString("email"), conector.getResultado().getString("sexo"));
        }
        conector.desconectarse();
        return cliente;
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

        this.notificar();
    }

    /**
     * Edita un cliente en la base de datos
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
    public void editarCliente(String id, String nombres, String apellidos, String direccion, String celular, String email, String sexo) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("UPDATE Clientes SET "
                + "nombres = '" + nombres + "',"
                + "apellidos ='" + apellidos + "',"
                + "direccion ='" + direccion + "',"
                + "celular = '" + celular + "',"
                + "email ='" + email + "',"
                + "sexo ='" + sexo + "'"
                + " WHERE id ='" + id
                + "'");
        conector.desconectarse();
        this.notificar();

    }

    /**
     * Elimina un cliente de la base de datos
     *
     * @param id
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void eliminarCliente(String id) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("DELETE FROM Clientes  "
                + " WHERE id ='" + id
                + "'");
        conector.desconectarse();
        this.notificar();
    }
    
    
    public int getTotalHombres() throws ClassNotFoundException, SQLException{
        int resultado=0;
        conector.conectarse();
        conector.crearConsulta("SELECT COUNT(*) s FROM clientes Where sexo = 'Masculino'");

        if (conector.getResultado().next()) {
            resultado = Integer.parseInt(conector.getResultado().getString("s"));
        }
        conector.desconectarse();
        return resultado;
    }
    
    public int getTotalMujeres() throws ClassNotFoundException, SQLException{
         int resultado=0;
        conector.conectarse();
        conector.crearConsulta("SELECT COUNT(*) s FROM clientes Where sexo = 'Femenino'");

        if (conector.getResultado().next()) {
            resultado = Integer.parseInt(conector.getResultado().getString("s"));
        }
        conector.desconectarse();
        return resultado;
    }    
}
