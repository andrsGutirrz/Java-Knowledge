/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear;


import mochilear.logica.Model;
import mochilear.presentacion.control.BusetaControl;
import mochilear.presentacion.control.ClientesControl;
import mochilear.presentacion.control.LugarControl;
import mochilear.presentacion.control.ViajeControl;
import mochilear.presentacion.model.BusetaModel;
import mochilear.presentacion.model.ClientesModel;
import mochilear.presentacion.model.LugarModel;
import mochilear.presentacion.model.ViajeModel;
import mochilear.presentacion.view.ClientesView;
import mochilear.presentacion.view.Home;
import mochilear.presentacion.view.RegistrarBusetaView;
import mochilear.presentacion.view.RegistrarClienteView;
import mochilear.presentacion.view.RegistrarLugarView;
import mochilear.presentacion.view.RegistrarViajeView;

/**
 *
 * @author andres
 */
public class Mochilear {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Home appView=new Home();
        appView.setVisible(true);  
        DOMAINMODEL = Model.instance();
        
        //===============================================================
        
        // @@@@@@@@@@@@@@@@@ | VISTAS | @@@@@@@@@@@@@@@@@
        CLIENTESVIEW = new ClientesView();
        REGISTRARCLIENTE = new RegistrarClienteView();
        REGISTRARLUGAR = new RegistrarLugarView();
        REGISTRARVIAJE = new RegistrarViajeView();
        REGISTRARBUSETA = new RegistrarBusetaView();
       //#####################| AÑADIR AL CONTENEDOR |#######################
        appView.contenedor.add(REGISTRARCLIENTE);
        appView.contenedor.add(CLIENTESVIEW);
        appView.contenedor.add(REGISTRARLUGAR);
        appView.contenedor.add(REGISTRARVIAJE);
        appView.contenedor.add(REGISTRARBUSETA);
        //      ==========================
        REGISTRARCLIENTE.setVisible(false);
        CLIENTESVIEW.setVisible(false);
        REGISTRARLUGAR.setVisible(false);
        REGISTRARVIAJE.setVisible(false);
        REGISTRARBUSETA.setVisible(false);
        //############################################
        
        // @@@@@@@@@@@@@@@@@ | MODELOS | @@@@@@@@@@@@@@@@@
        CLIENTESMODEL = new ClientesModel();
        LUGARMODEL = new LugarModel();
        VIAJEMODEL = new ViajeModel();
        BUSETAMODEL = new BusetaModel();
        // @@@@@@@@@@@@@@@@@ | CONTROLADORES | @@@@@@@@@@@@@@@@@
        CLIENTESCONTROL = new ClientesControl(CLIENTESVIEW,REGISTRARCLIENTE,CLIENTESMODEL,DOMAINMODEL);
        LUGARCONTROL = new LugarControl(REGISTRARLUGAR,LUGARMODEL,DOMAINMODEL);
        VIAJECONTROL = new ViajeControl(REGISTRARVIAJE,VIAJEMODEL,DOMAINMODEL);
        BUSETACONTROL = new BusetaControl(REGISTRARBUSETA, BUSETAMODEL,DOMAINMODEL);
    }
     
    
    // VARIABLES ESTATICAS
    
    // GRUPO PARA CLIENTES
    public static ClientesView CLIENTESVIEW;
    public static ClientesModel CLIENTESMODEL;
    public static ClientesControl CLIENTESCONTROL;
    public static RegistrarClienteView REGISTRARCLIENTE;
    // GRUPO PARA LUGAR
    public static RegistrarLugarView REGISTRARLUGAR;
    public static LugarModel LUGARMODEL;
    public static LugarControl LUGARCONTROL;
    // GRUPO PARA VIAJE
    public static RegistrarViajeView REGISTRARVIAJE;
    public static ViajeControl VIAJECONTROL;
    public static ViajeModel VIAJEMODEL;
    //GRUPO PARA BUSETA
    public static RegistrarBusetaView REGISTRARBUSETA;
    public static BusetaControl BUSETACONTROL;
    public static BusetaModel BUSETAMODEL;
    //DOMAIN MODEL
    public static Model DOMAINMODEL;
}
