package agenciaviajes.presentacion;

import agenciaviajes.negocio.GestorClientes;
import agenciaviajes.utils.Utilidades;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;

/**
 *
 * @author Libardo, Ricardo, Julio
 */
public class GUIClientesController extends AActionController {

    private final GestorClientes gestor; // Modelo
    private final GUIClientes vista; //Vista

    public GUIClientesController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorClientes) myModel;
        this.vista = (GUIClientes) myView;
    }

    /**
     * Este método se invoca automáticamente desde GUICliente al presionar los
     * botones de accion
     *
     * @param e objeto tipo ActionEvent que indica qué boton se presionó
     */
    @Override
    public void actualizar(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "GRABAR":
                if (vista.validarFormulario()) {
                    if (vista.getAccion().equals("AGREGAR")) {
                        //AGREGAR
                        agregarCliente();

                    } else {
                        editarCliente();
                    }
                    vista.limpiarCajas(true);
                    vista.botonesEstadoInicial();
                }
                break;
            case "ELIMINAR":
                eliminarCliente();
                break;
        }
    }

    private void agregarCliente() {
        try {
            gestor.agregarCliente(vista.getId(), vista.getNombres(), vista.getApellidos(), vista.getDireccion(), vista.getCelular(), vista.getEmail(), vista.getSexo());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeError("Error al agregar el cliente", "Atención");
        }
        Utilidades.mensajeExito("Empleado agregado con éxito", "Atención");
    }

    private void editarCliente() {
        try {
            // EDITAR
            gestor.editarCliente(vista.getId(), vista.getNombres(), vista.getApellidos(), vista.getDireccion(), vista.getCelular(), vista.getEmail(), vista.getSexo());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeError("Error al editar el cliente", "Atención");
        }
        Utilidades.mensajeExito("Empleado modificado con éxito", "Atención");
    }

    private void eliminarCliente() {
        if (Utilidades.mensajeConfirmacion("Está seguro que desea eliminar el empleado " + vista.getId() + "?", "Atención") == JOptionPane.YES_OPTION) {
            try {
                gestor.eliminarCliente(vista.getId());
                Utilidades.mensajeExito("Empleado borrado con éxito", "Atención");
                vista.limpiarCajas(true);
                vista.botonesEstadoInicial();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
                Utilidades.mensajeError("Error al eliminar el cliente", "Atención");
            }
        }

    }

}
