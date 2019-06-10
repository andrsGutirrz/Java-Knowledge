/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentospresentacion.Model;

import instrumentosEntidades.TipoInstrumento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author LENOVO
 */
public class TipoInstrumentosModel extends java.util.Observable{
    TipoInstrumento filter; 
    TipoInstrumentoTableModel Tinstrumentos;
    HashMap<String,String> errores;
    String mensaje;

    public TipoInstrumentosModel() {
    }

    public void init(){ 
        filter = new TipoInstrumento();
        List<TipoInstrumento> rows = new ArrayList<TipoInstrumento>();
        this.setTinstrumentos(rows);
        clearErrors();
    }
    
    public void setTinstrumentos(List<TipoInstrumento> ins){
        int[] cols={TipoInstrumentoTableModel.CODIGO,TipoInstrumentoTableModel.NOMBRE,TipoInstrumentoTableModel.UNIDAD};
        this.Tinstrumentos =new TipoInstrumentoTableModel(cols,ins);  
        setChanged();
        notifyObservers();        
    }
    
    public TipoInstrumento getFilter() {
        return filter;
    }
    
    public void setFilter(TipoInstrumento filter) {
        this.filter = filter;
    }
    
     public  TipoInstrumentoTableModel getTinstrumentos() {
        return Tinstrumentos;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje(""); 
    }
    
    public void eliminar(){
        
    }
    
}

