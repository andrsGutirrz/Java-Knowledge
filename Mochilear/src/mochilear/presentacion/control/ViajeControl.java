/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.control;

import java.util.List;
import mochilear.Entidades.Lugar;
import mochilear.Entidades.Viaje;
import mochilear.logica.Model;
import mochilear.presentacion.model.ViajeModel;
import mochilear.presentacion.view.RegistrarViajeView;

/**
 *
 * @author andres
 */
public class ViajeControl {
    // relacion con el view y el model
    RegistrarViajeView registarViajeView;
    ViajeModel viajemod;
    // relacion con el modelo del dao
    Model model;

    public ViajeControl(RegistrarViajeView registarViajeView, ViajeModel viajemod, Model model) {
        List<Lugar> ls = model.getAllLugar();
        viajemod.initCombo(ls.toArray(new Lugar[ls.size()]));
        this.registarViajeView = registarViajeView;
        this.viajemod = viajemod;
        this.model = model;
        this.registarViajeView.setControl(this);
        this.registarViajeView.setModel(viajemod);
    }

    public void registrarViaje() throws Exception {
        Viaje vj = new Viaje();
        Lugar lg = ((Lugar)registarViajeView.lugar_combo.getSelectedItem()); // obtener del combo
        
        vj.setLugar(lg.getNombre());
        vj.setLugar_salida(registarViajeView.lugar_salida_txt.getText());
        vj.setPrecio(Float.parseFloat(registarViajeView.precio_txt.getText()));
        String _ano = registarViajeView.ano_txt.getText();        
        String _mes = registarViajeView.mes_txt.getText();  
        String _dia = registarViajeView.dia_txt.getText();  
        vj.setFecha_salida(hacerFecha(_dia,  _mes,  _ano));
        
        model.registrarViaje(vj);
    }
    
    public String hacerFecha(String _dia, String _mes, String _ano){
        String _fecha = "%s-%s-%s";
        _fecha = String.format(_fecha, _ano,_mes,_dia);
        return _fecha;
    }   
    
    public void actualizarCombo(){
        List<Lugar> ls = model.getAllLugar();
        viajemod.initCombo(ls.toArray(new Lugar[ls.size()]));
    }
}
