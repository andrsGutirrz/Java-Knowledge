/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.control;

import java.util.List;
import mochilear.Entidades.Cliente;
import mochilear.Entidades.Cliente_Viaje;
import mochilear.Entidades.Viaje;
import mochilear.logica.Model;
import mochilear.presentacion.model.ClientesModel;
import mochilear.presentacion.view.ClientesView;
import mochilear.presentacion.view.RegistrarClienteView;

/**
 *
 * @author andres
 */

public class ClientesControl {
    // relacion con el view y el model
    ClientesView cliview;
    RegistrarClienteView regview;
    ClientesModel climod;
    // relacion con el modelo del dao
    Model model;

    public ClientesControl(ClientesView cliview,RegistrarClienteView regview, ClientesModel climod, Model model) {
        climod.init();
        List<Viaje> ls = Model.instance().getAllViaje();
        climod.initCombo(ls.toArray(new Viaje[ls.size()]));
        this.cliview = cliview;
        this.climod = climod;
        this.model = model;
        this.regview = regview;
        cliview.setClicon(this);
        cliview.setClimod(climod);
        regview.setClicon(this);
        regview.setClimod(climod);        
    }
    
    
    public void desplegarTodosClientes(){
        List<Cliente> rows = Model.instance().getAllClientes();
        climod.setClitable(rows);
    }
    
    public void registrarCliente() throws Exception{
        Cliente cl = new Cliente();
        Cliente_Viaje cv = new Cliente_Viaje();
        Viaje v = ((Viaje)regview.viajes_combo.getSelectedItem()); // obtener del combo
        //Registrar cliente
        cl.setCedula(regview.getCed_txt().getText());
        cl.setNombre(regview.getNom_txt().getText());
        cl.setTelefono(regview.getTel_txt().getText());
        cl.setResidencia(regview.res_txt.getText());
        cl.setCorreo(regview.getCor_txt().getText());
        cl.setObservaciones(regview.obs_txt.getText());
        // Registrar Clienete_viaje
        cv.setCampos(Integer.parseInt(regview.campos_txt.getText())); 
        cv.setCliente(cl.getTelefono());
        cv.setFecha(java.time.LocalDate.now().toString());
        cv.setFecha_salida(v.getFecha_salida());
        cv.setLugar(v.getLugar());
        cv.setPrecio(v.getPrecio());
        cv.setLugar_salida(v.getLugar_salida());
        
        model.registrarCliente(cl);
        model.registrarCliente_Viaje(cv);
    }
    
    public void actualizarCombo(){
        List<Viaje> ls = Model.instance().getAllViaje();
        climod.initCombo(ls.toArray(new Viaje[ls.size()]));
    }
}
