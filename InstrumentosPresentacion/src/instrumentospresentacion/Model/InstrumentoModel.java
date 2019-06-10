/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentospresentacion.Model;

import instrumentosEntidades.Instrumento;
import instrumentosEntidades.TipoInstrumento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author marcovinicio
 */
public class InstrumentoModel extends Observable {
    Instrumento current;
    ComboBoxModel<TipoInstrumento> tipos;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    
    //======METODOS========
    public InstrumentoModel() {
    }
    //---------------------
    public void init(TipoInstrumento[] tipos){
        setTipos(tipos);
        setCurrent(new Instrumento());
        clearErrors();
    }
    //---------------------

    public ComboBoxModel<TipoInstrumento> getTipos() {
        return tipos;
    }
    
    //--------------------
    public void setTipos(TipoInstrumento[] tipos) {
        this.tipos = new DefaultComboBoxModel(tipos);
        setChanged();
        notifyObservers();
    }
    //--------------------
    public int getModo() {
        return modo;
    }
    //--------------------
    public void setModo(int modo) {
        this.modo = modo;
    }
    //--------------------
    public String getMensaje() {
        return mensaje;
    }
    //--------------------
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //--------------------
    public HashMap<String, String> getErrores() {
        return errores;
    }
    //--------------------
    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }
    //--------------------
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
    }
    //--------------------
    public Instrumento getCurrent() {
        return current;
    }
    //--------------------
    public void setCurrent(Instrumento current) {
        this.current = current;
        setChanged();
        notifyObservers();        
    }
    //-------------------
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    //------------------
    
}
