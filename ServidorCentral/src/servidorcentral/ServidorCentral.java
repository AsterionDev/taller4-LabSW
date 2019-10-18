/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral;

import servidorcentral.servicio.ServidorCentralServer;

/**
 *
 * @author Asus
 */
public class ServidorCentral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorCentralServer regSer = new ServidorCentralServer();
        regSer.iniciar();
    }
    
}
