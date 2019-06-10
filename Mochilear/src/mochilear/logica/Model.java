/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.logica;

import java.util.List;
import mochilear.Entidades.Buseta;
import mochilear.Entidades.Cliente;
import mochilear.Entidades.Cliente_Viaje;
import mochilear.Entidades.Lugar;
import mochilear.Entidades.Provincia;
import mochilear.Entidades.Viaje;
import mochilear.datos.Dao;


/**
 *
 * @author andres
 */

public class Model {
    private Dao dao;
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }
    private Model(){
        dao = new Dao();
    }
    
    //######################## CLIENTE //########################
    
    //Obtener todos los clientes, sin filtro
    public List<Cliente> getAllClientes(){//retorna todos los tipoInstrumento
        return dao.getAllClientes();
    }
    
    public void registrarCliente(Cliente cl) throws Exception{
        dao.registrarCliente(cl);
    }
    
    //######################## FIN CLIENTE //########################
    
    
    //######################## LUGAR //######################## 
    public List<Provincia> getAllProvincia() {
        return dao.getAllProvincia();
    }
    
    //Registrar un lugar
    public void registrarLugar(Lugar lg) throws Exception{
        dao.registrarLugar(lg);
    }
    
    public List<Lugar> getAllLugar() {
        return dao.getAllLugar();
    }

    
    //######################## FIN LUGAR //########################
    
    //######################## VIAJE  //########################
    
    public List<Viaje> getAllViaje() {
        return dao.getAllViaje();
    }
    
    public void registrarViaje(Viaje vj) throws Exception {
        dao.registrarViaje(vj);
    }
    
        
    //######################## FIN VIAJE  //########################

    //######################## CLIENTE_VIAJE  //########################
    
    public void registrarCliente_Viaje(Cliente_Viaje cv) throws Exception {
        dao.registrarCliente_Viaje(cv);
    }
    
    //######################## FIN CLIENTE_VIAJE  //########################

    
    //########################  BUSETA  //########################
    public void registrarBuseta(Buseta bs) throws Exception {
        dao.registrarBuseta(bs);
    }
    //######################## FIN BUSETA  //########################


}//fin clase
