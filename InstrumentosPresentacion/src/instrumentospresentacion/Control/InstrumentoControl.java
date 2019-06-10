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
import instrumentospresentacion.View.InstrumentoView;
import java.util.List;

/**
 *
 * @author marcovinicio
 */
public class InstrumentoControl {
    Model domainModel;    
    InstrumentoView view;
    InstrumentoModel model;
    //======METODOS==========

    public InstrumentoControl(Model domainModel, InstrumentoView view, InstrumentoModel model) {
        model.init(domainModel.getTipoInstrumentos().toArray(new TipoInstrumento[domainModel.getTipoInstrumentos().size()]));
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        view.setControl(this);
        view.setModel(model);
    }
    //------------------------------------------------
    public void guardar(){
        InstrumentosModel instrumentosModel = Principal.INSTRUMENTOS_VIEW.getModel();
        Instrumento nuevo = new Instrumento();
        model.clearErrors();
        //===============================================
        nuevo.setSerie(view.SerieField.getText());
        if (view.SerieField.getText().length()==0){
            model.getErrores().put("Serie", "Serie requerido");
        }
        //===============================================
        nuevo.setDescripcion(view.DescripcionField.getText());
        if (view.DescripcionField.getText().length()==0){
            model.getErrores().put("Descripcion", "Descripcion requerido");
        }
        //===============================================
        nuevo.setMinimo(Integer.parseInt(view.MinField.getText()));
        if (view.MinField.getText().length()==0){
            model.getErrores().put("Minimo", "Minimo requerido");
        }
        //===============================================
        nuevo.setMaximo(Integer.parseInt(view.MaxField.getText()));
        if (view.MaxField.getText().length()==0){
            model.getErrores().put("Maximo", "Maximo requerido");
        }
        //===============================================
        nuevo.setTolerancia(Integer.parseInt(view.ToleranciaField.getText()));
        if (view.MaxField.getText().length()==0){
            model.getErrores().put("Maximo", "Maximo requerido");
        }
        //===============================================
       nuevo.setTipo((TipoInstrumento) view.TipoComboBox.getSelectedItem());
      
        //--------------------------
        List<Instrumento> instrumentos;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Principal.MODO_AGREGAR:
                        domainModel.InstrumentoAgregar(nuevo);
                        model.setMensaje("INSTRUMENTO AGREGADO");
                        model.setCurrent(new Instrumento());
                        instrumentosModel.clearErrors();
                        
                        instrumentos = domainModel.InstrumentoSerch(instrumentosModel.getFilter());
                        instrumentosModel.setInstrumentos(instrumentos);                        
                        break;
                    case Principal.MODO_EDITAR:
                        domainModel.InstrumentoActualzar(nuevo);
                        model.setMensaje("INSTRUMENTO MODIFICADADO");
                        model.setCurrent(nuevo);

                        instrumentos = domainModel.InstrumentoSerch(instrumentosModel.getFilter());
                        instrumentosModel.setInstrumentos(instrumentos);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("serie", "Instrumento ya existe");
                model.setMensaje("INSTRUMENTO YA EXISTE");
                model.setCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
    }  
    
}
