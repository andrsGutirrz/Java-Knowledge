/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.control;

import java.util.List;
import mochilear.Entidades.Buseta;
import mochilear.Entidades.Viaje;
import mochilear.logica.Model;
import mochilear.presentacion.model.BusetaModel;
import mochilear.presentacion.view.RegistrarBusetaView;

/**
 *
 * @author andres
 */
public class BusetaControl {
    // relacion con el view y el model
    RegistrarBusetaView regView;
    BusetaModel busetaMod;
    // relacion con el modelo del dao
    Model model;

    public BusetaControl() {
    }

    public BusetaControl(RegistrarBusetaView regView, BusetaModel busetaMod, Model model) {
        List<Viaje> ls = model.getAllViaje();
        busetaMod.initCombo(ls.toArray(new Viaje[ls.size()]));
        this.regView = regView;
        this.busetaMod = busetaMod;
        this.model = model;
        this.regView.setModel(busetaMod);
        this.regView.setControl(this);
    }

    public void registrarBuseta() throws Exception {
        Buseta bs = new Buseta();        
        Viaje v = ((Viaje)regView.viajes_combo.getSelectedItem()); // obtener del combo
        
        bs.setProveedor(regView.proveedor_txt.getText());
        bs.setAsientos_totales(Integer.parseInt(regView.asientos_txt.getText()));
        bs.setAsientos_disponibles(bs.getAsientos_totales());// mismo valor al inicio
        bs.setTelefono(regView.telefono_txt.getText());
        bs.setFecha_salida(v.getFecha_salida());
        bs.setLugar(v.getLugar());
        bs.setLugar_salida(v.getLugar_salida());
        
        model.registrarBuseta(bs);
    }
    
    public void actualizarCombo(){
        List<Viaje> ls = model.getAllViaje();
        busetaMod.initCombo(ls.toArray(new Viaje[ls.size()]));
    }
    
}
