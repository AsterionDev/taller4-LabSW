/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcf;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mvcf.AController;
import mvcf.AModel;
import mvcf.AView;


/**
 *
 * @author pmage
 */
public abstract class AKeyController extends AController implements KeyListener{
    protected AModel myModel;
    protected AView myView;

    public AKeyController(AView aView, AModel aModel) {
            myView = aView;
            myModel = aModel;
    
    }
 

    @Override
    public void keyTyped(KeyEvent e) {
            // Metodo Hook
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
         myModel.setSourceView(myView);
         //String value = this.getInfo();
         if(this.isValid())
         // if (!value.isEmpty() && value.matches("^(?![+-]$|[-+]E|E|$|\\.$)[+-]?\\d*(\\.?\\d*)?(E-?\\d+)?$")) {
         this.actualizar();
        
    }
    
     abstract public String getInfo();
     abstract public boolean isValid();
    
}
