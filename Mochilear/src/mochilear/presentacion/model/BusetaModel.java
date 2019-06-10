/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.model;


import java.util.Observable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import mochilear.Entidades.Viaje;

/**
 *
 * @author andres
 */
public class BusetaModel extends Observable{
    
    
    ComboBoxModel<Viaje> viajes;
    
    public BusetaModel() {
    }

    // para el combo
        public ComboBoxModel<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(Viaje[] _viajes) {
        this.viajes = new DefaultComboBoxModel(_viajes);
        setChanged();
        notifyObservers();
    }
    
    public void initCombo(Viaje[] _provincias){
        this.setViajes(_provincias);
    }
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
}
