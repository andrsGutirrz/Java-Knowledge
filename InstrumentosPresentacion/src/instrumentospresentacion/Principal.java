/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentospresentacion;

import instrumentos.logic.Model;
import instrumentospresentacion.Control.InstrumentoControl;
import instrumentospresentacion.Control.InstrumentosControl;
import instrumentospresentacion.Control.TipoInstrumentoControl;
import instrumentospresentacion.Control.TipoInstrumentosControl;
import instrumentospresentacion.Model.InstrumentoModel;
import instrumentospresentacion.Model.InstrumentosModel;
import instrumentospresentacion.Model.TipoInstrumentoModel;
import instrumentospresentacion.Model.TipoInstrumentosModel;
import instrumentospresentacion.View.AppView;
import instrumentospresentacion.View.InstrumentoView;
import instrumentospresentacion.View.InstrumentosView;
import instrumentospresentacion.View.TipoInstrumentoView;
import instrumentospresentacion.View.TipoInstrumentosView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author LENOVO
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model domainModel = Model.instance();
        AppView appView=new AppView();
        appView.setVisible(true);
        TipoInstrumentoModel TinstrumentoModel = new TipoInstrumentoModel();
        TipoInstrumentosModel TinstrumentosModel = new TipoInstrumentosModel();
        InstrumentoModel instrumentoModel= new InstrumentoModel();
        InstrumentosModel instrumentosModel= new InstrumentosModel();
        //=====================================================================
        TipoInstrumentosView tipoInstosView= new TipoInstrumentosView();
        appView.contenedor.add( tipoInstosView);
         tipoInstosView.setVisible(false);
        TIPOINSTS_VIEW= tipoInstosView;
        //appView.contenedor.add(personasView);
        TipoInstrumentosControl tipoInstosControl = new TipoInstrumentosControl( tipoInstosView,TinstrumentosModel,domainModel);
        //personasView.setVisible(false);
        //=====================================================================
        TipoInstrumentoView tipoInstView = new TipoInstrumentoView();
        appView.contenedor.add( tipoInstView);
        tipoInstView.setVisible(false);
        TIPOINST_VIEW=tipoInstView;
       // appView.contenedor.add(personaView);
        TipoInstrumentoControl tipoInstControl = new TipoInstrumentoControl(domainModel,tipoInstView,TinstrumentoModel);
        //=====================================================================
        InstrumentosView instrumentosView= new InstrumentosView();
        appView.contenedor.add(instrumentosView);
        instrumentosView.setVisible(false);
        INSTRUMENTOS_VIEW=instrumentosView;
        InstrumentosControl instrumentosControl = new InstrumentosControl(domainModel,instrumentosView,instrumentosModel);
        //=====================================================================
        InstrumentoView instrumentoView= new InstrumentoView();
        appView.contenedor.add(instrumentoView);
        instrumentoView.setVisible(false);
        INSTRUMENTO_VIEW=instrumentoView;
        InstrumentoControl instrumentoControl = new InstrumentoControl(domainModel,instrumentoView,instrumentoModel);
    }
    public static TipoInstrumentoView TIPOINST_VIEW;
    public static TipoInstrumentosView TIPOINSTS_VIEW;
    public static InstrumentoView INSTRUMENTO_VIEW;
    public static InstrumentosView INSTRUMENTOS_VIEW;      
       
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static final int MODO_BORRAR=2;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
}
