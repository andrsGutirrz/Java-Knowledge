/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentospresentacion.Control;

import instrumentos.logic.Model;
import instrumentosEntidades.Instrumento;
import instrumentosEntidades.TipoInstrumento;
import instrumentospresentacion.Model.InstrumentoModel;
import instrumentospresentacion.Model.InstrumentosModel;
import instrumentospresentacion.Principal;
import instrumentospresentacion.View.InstrumentosView;
import java.util.List;

/**
 *
 * @author marcovinicio
 */
public class InstrumentosControl {
    InstrumentosView view;
    InstrumentosModel model;
    Model domainModel;
    //======METODOS========

    public InstrumentosControl(Model domainModel,InstrumentosView view, InstrumentosModel model) {
        model.init();
        this.view = view;
        this.model = model;
        this.domainModel = domainModel;
        view.setControl(this);
        view.setModel(model);
    }
    //------------------------
    //------------------------------
    public void buscar(){
        model.getFilter().setDescripcion(view.filterField.getText());
        model.clearErrors();
        List<Instrumento> rows = domainModel.InstrumentoSerch(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("filterField", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setInstrumentos(rows);
    }
    //------------------------------
    public void preAgregar(){
        InstrumentoModel instrumentoModel = Principal.INSTRUMENTO_VIEW.getModel();
        instrumentoModel.clearErrors();
        instrumentoModel.setModo(Principal.MODO_AGREGAR);
        instrumentoModel.setCurrent(new Instrumento());
        TipoInstrumento[] miarray = new TipoInstrumento[domainModel.tipoInstrumentoSerch(new TipoInstrumento("","","")).size()];
        miarray=domainModel.tipoInstrumentoSerch(new TipoInstrumento("","","")).toArray(miarray);
        instrumentoModel.setTipos(miarray);
        Principal.INSTRUMENTO_VIEW.setVisible(true);
    }
    //------------------------------
    public void editar(int row){
        InstrumentoModel instrumentoModel = Principal.INSTRUMENTO_VIEW.getModel();
        instrumentoModel.clearErrors();
        Instrumento seleccionada = model.getInstrumentos().getRowAt(row); 
        instrumentoModel.setModo(Principal.MODO_EDITAR);
        instrumentoModel.setCurrent(seleccionada);
        Principal.INSTRUMENTO_VIEW.setVisible(true);
    }
    //-----------------------------
    public void borrar(int row) throws Exception{
         InstrumentoModel instrumentoModel = Principal.INSTRUMENTO_VIEW.getModel();
        instrumentoModel.clearErrors();
        Instrumento seleccionada = model.getInstrumentos().getRowAt(row);
        instrumentoModel.setModo(Principal.MODO_BORRAR);
        domainModel.InstrumentoBorrar(seleccionada);
    }
    
    
}
