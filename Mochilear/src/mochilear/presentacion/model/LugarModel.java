/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.model;

import java.util.Observable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import mochilear.Entidades.Provincia;

/**
 *
 * @author andres
 */
public class LugarModel extends Observable{

    ComboBoxModel<Provincia> provincias;

    public LugarModel() {
    }

    public ComboBoxModel<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincia[] _provincias) {
        this.provincias = new DefaultComboBoxModel(_provincias);
        setChanged();
        notifyObservers();
    }
    
    public void init(Provincia[] _provincias){
        this.setProvincias(_provincias);
    }
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
