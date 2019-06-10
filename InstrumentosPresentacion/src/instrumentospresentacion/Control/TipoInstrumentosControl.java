/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentospresentacion.Control;

import instrumentos.logic.Model;
import instrumentosEntidades.TipoInstrumento;
import instrumentospresentacion.Model.TipoInstrumentoModel;
import instrumentospresentacion.Model.TipoInstrumentosModel;
import instrumentospresentacion.Principal;
import instrumentospresentacion.View.TipoInstrumentosView;
import java.util.List;

/**
 *
 * @author marcovinicio
 */
public class TipoInstrumentosControl {
    TipoInstrumentosView view;
    TipoInstrumentosModel model;
    Model domainModel;
    //===========METODOS============

    public TipoInstrumentosControl(TipoInstrumentosView view, TipoInstrumentosModel model, Model domainModel) {
        model.init();
        this.view = view;
        this.model = model;
        this.domainModel = domainModel;
        view.setController(this);
        view.setModel(model);
    }
    //------------------------------
    public void buscar(){
        model.getFilter().setNombre(view.nombreField.getText());
        model.clearErrors();
        List<TipoInstrumento> rows = domainModel.tipoInstrumentoSerch(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("nombreField", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setTinstrumentos(rows);
    }
    //------------------------------
    public void preAgregar(){
        TipoInstrumentoModel TinstModel = Principal.TIPOINST_VIEW.getModel();
        TinstModel.clearErrors();
        TinstModel.setModo(Principal.MODO_AGREGAR);
        TinstModel.setCurrent(new TipoInstrumento());
        Principal.TIPOINST_VIEW.setVisible(true);
    }
    //------------------------------
    public void editar(int row){
        TipoInstrumentoModel TinstModel = Principal.TIPOINST_VIEW.getModel();
        TinstModel.clearErrors();
        TipoInstrumento seleccionada = model.getTinstrumentos().getRowAt(row); 
        TinstModel.setModo(Principal.MODO_EDITAR);
        TinstModel.setCurrent(seleccionada);
        Principal.TIPOINST_VIEW.setVisible(true);
    }
    //-----------------------------
    public void borrar(int row) throws Exception{
        TipoInstrumentoModel TinstModel = Principal.TIPOINST_VIEW.getModel();
        TinstModel.clearErrors();
        TipoInstrumento seleccionada = model.getTinstrumentos().getRowAt(row);
        TinstModel.setModo(Principal.MODO_BORRAR);
        domainModel.tipoInstrumentoBorrar(seleccionada);
    }

   /* public void salir(){
        domainModel.close();
    }*/
    
    
    
}
