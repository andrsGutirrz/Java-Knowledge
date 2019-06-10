/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.control;

import java.util.List;
import mochilear.Entidades.Lugar;
import mochilear.Entidades.Provincia;
import mochilear.logica.Model;
import mochilear.presentacion.model.LugarModel;
import mochilear.presentacion.view.RegistrarLugarView;

/**
 *
 * @author andres
 */

public class LugarControl {
    // relacion con el view y el model
    RegistrarLugarView registarLugarView;
    LugarModel lugarmod;
    // relacion con el modelo del dao
    Model model;
    
    

    public LugarControl(RegistrarLugarView registarLugarView, LugarModel lugarmod, Model model) {        
        List<Provincia> ls = model.getAllProvincia();
        lugarmod.init(ls.toArray(new Provincia[ls.size()]));
        this.registarLugarView = registarLugarView;
        this.lugarmod = lugarmod;
        this.model = model;
        registarLugarView.setLugarControl(this);
        registarLugarView.setLugarModel(lugarmod);
    }

    public LugarControl() {
    }

    public RegistrarLugarView getRegistarLugarView() {
        return registarLugarView;
    }

    public LugarModel getLugarmod() {
        return lugarmod;
    }

    public Model getModel() {
        return model;
    }

    public void setRegistarLugarView(RegistrarLugarView registarLugarView) {
        this.registarLugarView = registarLugarView;
    }

    public void setLugarmod(LugarModel lugarmod) {
        this.lugarmod = lugarmod;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public void registrarLugar() throws Exception{
        Lugar lg = new Lugar();//registarLugarView
        lg.setNombre(registarLugarView.nombre_txt.getText());
        lg.setDescripcion(registarLugarView.descripcion_txt.getText());
        lg.setDireccion(registarLugarView.direccion_txt.getText());
        lg.setProvincia(((Provincia)registarLugarView.combo_provincias.getSelectedItem()).getNumero());
        model.registrarLugar(lg);
    }    
}
