package registraduria.main;

import registraduria.servicio.RegistraduriaServer;

/**
 *
 * @author libardo
 */
public class RunMain {
    public static void main(String args[]){
        RegistraduriaServer regSer = new RegistraduriaServer();
        regSer.iniciar();
    }
}
