/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import mochilear.Entidades.Cliente;
import mochilear.Entidades.Viaje;
import mochilear.presentacion.tablesmodel.ClientesTable;

/**
 *
 * @author andres
 */
public class ClientesModel extends Observable {

    ClientesTable clitable;
    ComboBoxModel<Viaje> viajes;
    
    public ClientesModel() {
        //clitable = new ClientesTable();
    }
    
    public void init(){ 
        List<Cliente> rows = new ArrayList<Cliente>();
        this.setClitable(rows);
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

    public ClientesTable getClitable() {
        return clitable;
    }

    public void setClitable(ClientesTable clitable) {
        this.clitable = clitable;
    }
    
    public void setClitable(List<Cliente> clientes) {
        int[] cols={ClientesTable.CEDULA,ClientesTable.NOMBRE,ClientesTable.TELEFONO,ClientesTable.RESIDENCIA,ClientesTable.CORREO};
        this.clitable = new ClientesTable(clientes,cols);  
        setChanged();
        notifyObservers();        
    }
    
}
