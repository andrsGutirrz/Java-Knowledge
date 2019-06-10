/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentospresentacion.Model;

import instrumentosEntidades.Instrumento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author marcovinicio
 */
public class InstrumentosModel extends Observable{
    Instrumento filter; 
    InstrumentoTableModel instrumentos;
    HashMap<String,String> errores;
    String mensaje;
    //=========METODOS===========

    public InstrumentosModel() {
    }
    //--------------------------
     public void init(){ 
        filter = new Instrumento();
        List<Instrumento> rows = new ArrayList<Instrumento>();
        this.setInstrumentos(rows);
        clearErrors();
    }
    //--------------------------
    public InstrumentoTableModel getInstrumentos() {
        return instrumentos;
    }
    //-------------------------
    public void setInstrumentos(List<Instrumento> instrumentos) {
        int[] cols={InstrumentoTableModel.SERIE,InstrumentoTableModel.TIPO,InstrumentoTableModel.DESCRIPCION,InstrumentoTableModel.MINIMO,InstrumentoTableModel.MAXIMO,InstrumentoTableModel.TOLERANCIA};
        this.instrumentos =new InstrumentoTableModel(cols,instrumentos);  
        setChanged();
        notifyObservers();        
    }
    //-------------------------

    public Instrumento getFilter() {
        return filter;
    }
    //-------------------------
    public void setFilter(Instrumento filter) {
        this.filter = filter;
    }
    //-------------------------
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    //-------------------------
    public HashMap<String, String> getErrores() {
        return errores;
    }
    //------------------------
    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }
    //------------------------
    public String getMensaje() {
        return mensaje;
    }
    //------------------------
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //------------------------
    public void clearErrors(){
       setErrores(new HashMap<String,String>());
       setMensaje("");
    }
    
    
     
    
    
}
