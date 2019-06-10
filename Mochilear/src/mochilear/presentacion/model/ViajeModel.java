/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.model;

import java.util.Observable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import mochilear.Entidades.Lugar;

/**
 *
 * @author andres
 */
public class ViajeModel extends Observable{
    ComboBoxModel<Lugar> lugares;

    public ViajeModel() {
    }
    
    public ComboBoxModel<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(Lugar[] _lugares) {
        this.lugares = new DefaultComboBoxModel(_lugares);
        setChanged();
        notifyObservers();
    }
    
    public void initCombo(Lugar[] _lugares){
        this.setLugares(_lugares);
    }
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
}
