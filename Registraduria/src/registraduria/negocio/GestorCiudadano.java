
package registraduria.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author libardo
 */
public class GestorCiudadano {

    private List<Ciudadano> listado;

    public GestorCiudadano() {
        listado = new ArrayList();
        inicializar();
    }

    public void inicializar() {
        try {
            listado.add(new Ciudadano("98000001", "Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "3145878752", "andrea@hotmail.com", "Femenino", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1998")));
            listado.add(new Ciudadano("98000002", "Libardo", "Pantoja", "Santa Barbar Popayan", "3141257845", "libardo@gmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1976")));
            listado.add(new Ciudadano("98000003", "Carlos", "Pantoja", "Santa Barbar Popayan", "3141257846", "carlos@gmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1976")));
            listado.add(new Ciudadano("98000004", "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino", new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1975")));
            listado.add(new Ciudadano("98000005", "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975")));
            listado.add(new Ciudadano("98000006", "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975")));
            listado.add(new Ciudadano("98000007", "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975")));
            listado.add(new Ciudadano("98000008", "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975")));
            listado.add(new Ciudadano("98000009", "Alberto", "Mendez Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975")));
            listado.add(new Ciudadano("98000010", "Alexander", "Ponce Yepes", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino", new SimpleDateFormat("dd/MM/yyyy").parse("01/05/1975")));
        } catch (ParseException ex) {
            Logger.getLogger(GestorCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ciudadano buscarCiudadano(String id) {
        for (Ciudadano ciu : listado) {
            if (ciu.getCedula().equals(id)) {
                return ciu;
            }
        }
        return null;
    }

}
