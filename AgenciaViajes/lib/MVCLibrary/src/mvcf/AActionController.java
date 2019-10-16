/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ahurtado
 */
public abstract class AActionController extends AController implements ActionListener {
    protected AModel myModel;
    protected AView myView;
   
    
    public AActionController(AModel myModel, AView myView){
        this.myModel = myModel;
        this.myView = myView;
    }
    
    @Override      
    public void actionPerformed(ActionEvent ae) {
         this.actualizar();
    }    
}
