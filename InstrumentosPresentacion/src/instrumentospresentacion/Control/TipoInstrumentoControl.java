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
import instrumentospresentacion.View.TipoInstrumentoView;
import java.util.List;
import javafx.application.Application;

/**
 *
 * @author marcovinicio
 */
public class TipoInstrumentoControl {
    Model domainModel;    
    TipoInstrumentoView view;
    TipoInstrumentoModel model;
    //==========METODOS==================

    public TipoInstrumentoControl(Model domainModel, TipoInstrumentoView view, TipoInstrumentoModel model) {
        model.init();
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        view.setControl(this);
        view.setModel(model);
    }
    //------------------------------------
    public void guardar(){
         TipoInstrumentosModel tipInstosModel = Principal.TIPOINSTS_VIEW.getModel();

        TipoInstrumento nueva = new TipoInstrumento();
        model.clearErrors();
        
        nueva.setCodigo(view.codTextField.getText());
        if (view.codTextField.getText().length()==0){
            model.getErrores().put("Codigo", "Codigo requerido");
        }
        
        nueva.setNombre(view.nomTextField.getText());
        if (view.nomTextField.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        
        nueva.setUnidad(view.uniTextField.getText());
        if (view.uniTextField.getText().length()==0){
            model.getErrores().put("Unidad", "Unidad requerido");
        }
        
        
        List<TipoInstrumento> tipoInstrumentos;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Principal.MODO_AGREGAR:
                        domainModel.tipoInstrumentoAgregar(nueva);
                        model.setMensaje("TIPO DE INSTRUMENTO AGREGADO");
                        model.setCurrent(new TipoInstrumento());
                        tipInstosModel.clearErrors();
                        tipoInstrumentos = domainModel.tipoInstrumentoSerch(tipInstosModel.getFilter());
                        tipInstosModel.setTinstrumentos(tipoInstrumentos);                       
                        break;
                    case Principal.MODO_EDITAR:
                        domainModel.tipoInstrumentoActualzar(nueva);
                        model.setMensaje("TIPO DE INSTRUMENTO MODIFICADO");
                        model.setCurrent(nueva);

                        tipoInstrumentos = domainModel.tipoInstrumentoSerch(tipInstosModel.getFilter());
                        tipInstosModel.setTinstrumentos(tipoInstrumentos);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("Codigo", "Tipo de Instrumento ya existe");
                model.setMensaje("TIPO DE INSTRUMENTO YA EXISTE");
                model.setCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nueva);
        }
    }   
    
    
}
