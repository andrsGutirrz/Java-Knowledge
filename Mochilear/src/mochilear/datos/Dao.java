/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mochilear.Entidades.Buseta;
import mochilear.Entidades.Cliente;
import mochilear.Entidades.Cliente_Viaje;
import mochilear.Entidades.Lugar;
import mochilear.Entidades.Provincia;
import mochilear.Entidades.Viaje;

/**
 *
 * @author Andres
 */
public class Dao {

    RelDatabase db;

    public Dao() {
        db = new RelDatabase();
    }

    //BUILDERS
    //Cliente Builder
    public Cliente clienteBuilder(ResultSet rs) {
        try {
            Cliente cl = new Cliente();
            cl.setCedula(rs.getString("cedula"));
            cl.setNombre(rs.getString("nombre"));
            cl.setTelefono(rs.getString("telefono"));
            cl.setCorreo(rs.getString("correo"));
            cl.setResidencia(rs.getString("residencia"));
            return cl;
        } catch (SQLException e) {
            return null;
        }
    }

    // Provincia Builder
    public Provincia provinciaBuilder(ResultSet rs) {
        try {
            Provincia pr = new Provincia();
            pr.setNumero(rs.getInt("numero"));
            pr.setNombre(rs.getString("nombre"));
            return pr;
        } catch (SQLException e) {
            return null;
        }
    }

    // Viaje Builder 
    public Viaje viajeBuilder(ResultSet rs) {
        try {
            Viaje vj = new Viaje();
            vj.setPrecio(rs.getFloat("precio"));
            vj.setFecha_salida(rs.getDate("fecha_salida").toString());
            vj.setLugar(rs.getString("lugar"));
            vj.setLugar_salida(rs.getString("lugar_salida"));
            return vj;
        } catch (SQLException e) {
            return null;
        }
    }

    //Lugar Builder
    public Lugar lugarBuilder(ResultSet rs) {
        try {
            Lugar lg = new Lugar();
            lg.setDescripcion(rs.getString("descripcion"));
            lg.setDireccion(rs.getString("direccion"));
            lg.setNombre(rs.getString("nombre"));
            lg.setProvincia(rs.getInt("provincia"));
            return lg;
        } catch (SQLException e) {
            return null;
        }
    }

    //Others
    //############################################## CLIENTES
    //Get all clients, with no filters
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            String sql = "select * from Cliente;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                clientes.add(clienteBuilder(rs));
            }
        } catch (SQLException e) {

        }
        return clientes;
    }

    //Registrar un cliente
    public void registrarCliente(Cliente cl) throws Exception {
        String sql = "insert into Cliente (cedula,nombre,telefono,correo,residencia)"
                + "values('%s','%s','%s','%s','%s')";
        sql = String.format(sql, cl.getCedula(), cl.getNombre(), cl.getTelefono(), cl.getCorreo(), cl.getResidencia());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Cliente ya existe");
        }
    }

    //######################################################## Lugares
    //Todas las provincias
    public List<Provincia> getAllProvincia() {
        List<Provincia> provincias = new ArrayList<Provincia>();
        try {
            String sql = "select * from Provincia;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                provincias.add(provinciaBuilder(rs));
            }
        } catch (SQLException e) {

        }
        return provincias;
    }

    //############################################# LUGAR
    public void registrarLugar(Lugar lg) throws Exception {
        String sql = "insert into Lugar (provincia,nombre,direccion,descripcion)"
                + "values('%d','%s','%s','%s')";
        sql = String.format(sql, lg.getProvincia(), lg.getNombre(), lg.getDireccion(), lg.getDescripcion());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Lugar ya existe");
        }
    }
    
        //Todas los lugares
    public List<Lugar> getAllLugar() {
        List<Lugar> lugares = new ArrayList<Lugar>();
        try {
            String sql = "select * from Lugar;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                lugares.add(lugarBuilder(rs));
            }
        } catch (SQLException e) {

        }
        return lugares;
    }

    // ############################################ VIAJE
    //Todas los viajes
    public List<Viaje> getAllViaje() {
        List<Viaje> viajes = new ArrayList<Viaje>();
        try {
            String sql = "select * from Viaje;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                viajes.add(viajeBuilder(rs));
            }
        } catch (SQLException e) {

        }
        return viajes;
    }
    
    
    public void registrarViaje(Viaje vj) throws Exception {
        String sql = "insert into Viaje (lugar,precio,fecha_salida,lugar_salida)"
           + "values('%s','%f','%s','%s')";
        sql = String.format(sql,vj.getLugar(),vj.getPrecio(),vj.getFecha_salida(),vj.getLugar_salida());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Viaje error");
        }
    }

    //######################################### CLIENTE_VIAJE
    public void registrarCliente_Viaje(Cliente_Viaje cl) throws Exception {
        String sql = "insert into Cliente_Viaje (cliente,fecha,precio,lugar,fecha_salida,lugar_salida,campos)"
           + "values('%s','%s','%f','%s','%s','%s','%d')";
        sql = String.format(sql,cl.getCliente(),cl.getFecha(), cl.getPrecio(),cl.getLugar(),cl.getFecha_salida(),cl.getLugar_salida(),cl.getCampos());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Cliente_Viaje error");
        }
    }
    
    //######################################### BUSETA

    public void registrarBuseta(Buseta bs) throws Exception {
        String sql = "insert into Buseta (proveedor,asientos_totales,asientos_disponibles,"
                + "telefono,lugar,fecha_salida,lugar_salida)"
           + "values('%s','%d','%d','%s','%s','%s','%s')";
        sql = String.format(sql,bs.getProveedor(),bs.getAsientos_totales(),bs.getAsientos_disponibles(),
                bs.getTelefono(),bs.getLugar(),bs.getFecha_salida(),bs.getLugar_salida());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Buseta error");
        }
        
    }
    
  

    /*
    public TipoInstrumento tipoInstrumentoGet(String codigo) throws Exception{
        String sql="select * from TipoInstrumento where codigo='%s'";
        sql = String.format(sql, codigo);
        ResultSet rs = db.executeQuery(sql);
        if(rs.next()){
            return tipoInstrumento(rs);
        }else{
            throw new Exception("Tipo de Instrumento no Existe");
        }
    }
    
    private TipoInstrumento tipoInstrumento(ResultSet rs){//Crea un TipoInstrumento
        try{
            TipoInstrumento ti = new TipoInstrumento();
            ti.setCodigo(rs.getString("codigo"));
            ti.setNombre(rs.getString("nombre"));
            ti.setUnidad(rs.getString("unidad"));
            return ti;
        }
        catch(SQLException e){
            return null;
        }
    }
    
    private Instrumento instrumento(ResultSet rs){
        try{
                Instrumento i = new Instrumento();
                i.setSerie(rs.getString("serie"));
                i.setTipo(tipoInstrumento(rs));
                i.setDescripcion(rs.getString("descripcion"));
                i.setMinimo(rs.getInt("minimo"));
                i.setMaximo(rs.getInt("maximo"));
                i.setTolerancia(rs.getInt("tolerancia"));
                return i;
            }
            catch(SQLException e){
                return null;  
        }
    }
    
    private Calibracion calibracion(ResultSet rs){
        try{
                Calibracion i = new Calibracion();
                i.setNumero(rs.getInt("numero"));
                i.setInstrumento(instrumento(rs));
                i.setFecha(rs.getDate("fecha"));
                i.setMediciones(rs.getInt("mediciones"));
                return i;
            }
            catch(SQLException e){
                return null;  
        }
    }
    
    private Medida medida(ResultSet rs){//Crea un TipoInstrumento
        try{
            Medida m = new Medida();
            m.setLectura(rs.getInt("lectura"));
            m.setReferencia(rs.getInt("referencia"));
            m.setMedida(rs.getInt("medida"));
            return m;
        }
        catch(SQLException e){
            return null;
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    public List<TipoInstrumento> tipoInstrumentoGetAll(){//retorna todos los tipoInstrumento
        List<TipoInstrumento> tInstrumentos = new ArrayList<TipoInstrumento>();
        try{
            String sql="select * from TipoInstrumento";
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                tInstrumentos.add(tipoInstrumento(rs));
            }
        }catch (SQLException e){
            
        }
        return tInstrumentos;
    }
    
    ///* Finds the specific instrument
    public List<TipoInstrumento> tipoInstrumentoSearch(TipoInstrumento filtro){
      List<TipoInstrumento> resultado = new ArrayList<TipoInstrumento>();
        try {
            String sql="select * from "+"TipoInstrumento p "+//en este caso no se ocupa join?
                    "where p.nombre like '%%%s%%'";
            sql=String.format(sql,filtro.getNombre());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(tipoInstrumento(rs));
            }
        } catch (SQLException ex) { }
        return resultado;
    } 
    
    public void tipoInstrumentoDelete(TipoInstrumento ti) throws Exception{
        String sql="delete from TipoInstrumento where codigo='%s'";
        sql = String.format(sql,ti.getCodigo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("TipoInstrumento no existe(borrar)");
        }
    }
    
    public void tipoInstrumentoAdd(TipoInstrumento ti) throws Exception{
        String sql="insert into TipoInstrumento (codigo,nombre,unidad)"+
                "values('%s','%s','%s')";
        sql=String.format(sql,ti.getCodigo(),ti.getNombre(),ti.getUnidad());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("TipoInstrumento ya existe");
        }
    } 
    
    public void tipoInstrumentoUpdate(TipoInstrumento p) throws Exception{
        String sql="update tipoInstrumento set nombre= '%s',unidad = '%s' "+
                "where codigo='%s'";
        sql=String.format(sql,p.getNombre(),p.getUnidad(),p.getCodigo());
        System.out.println(sql);
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("TipoInstrumento no existe(update)");
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public List<Instrumento> InstrumentoSerch(Instrumento filtro){
        List<Instrumento> resultado = new ArrayList<Instrumento>();
        try {
            String sql="select * from "+"instrumento i inner join tipoinstrumento t on i.tipo=t.codigo "+
                    "where descripcion like '%%%s%%'";
            sql=String.format(sql,filtro.getDescripcion());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                Instrumento aux = instrumento(rs);
                resultado.add(aux);
                aux.setCalibraciones(calibracionGetAll(aux));//crea list de calibraciones
            }
        } catch (SQLException ex) { }
        return resultado;
    
    }
    
     public void instrumentoAdd(Instrumento ti) throws Exception{
        String sql="insert into instrumento (serie,tipo,descripcion,minimo,maximo,tolerancia)"+
                "values('%s','%s','%s','%s','%s','%s')";
        sql=String.format(sql,ti.getSerie(),ti.getTipo().getCodigo(),ti.getDescripcion(),ti.getMinimo(),ti.getMaximo(),ti.getTolerancia());//tambien guardar el tipo de dato
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Instrumento ya existe");
        }
    } 
     
     
     public void instrumentoUpdate(Instrumento p) throws Exception{
        String sql="update instrumento set tipo= '%s',descripcion = '%s',"
                + " minimo = '%s', maximo = '%s', tolerancia = '%s'"+
                " where serie='%s'";
        sql=String.format(sql,p.getTipo().getCodigo(),p.getDescripcion(),p.getMinimo(),p.getMaximo(),
                p.getTolerancia(),p.getSerie());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Instrumento no existe(update)");
        }
    }
     
     public void InstrumentoDelete(Instrumento ti) throws Exception{
        String sql="delete from Instrumento where serie='%s'";
        sql = String.format(sql,ti.getSerie());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Instrumento no existe(borrar)");
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public void CalibracionAdd(Calibracion ti) throws Exception{
        String sql= "insert into calibracion (numero,instrumento,fecha,mediciones) "
                + "values (%d,'%s','%s','%s')";
        sql=String.format(sql,ti.getNumero(),ti.getInstrumento().getSerie(),ti.getFecha(),ti.getMediciones());//sql=String.format(sql,ti.getNumero(),ti.getInstrumento().getSerie(),ti.getFecha(),ti.getMediciones());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Instrumento ya existe");
        }  
    }
    
    public List<Calibracion> calibracionGetAll(Instrumento i){//retorna todos las calibraciones
        List<Calibracion> cali = new ArrayList<Calibracion>();
        try{
            String sql="select * from calibracion c inner join instrumento i on c.instrumento=i.serie"
                    + " inner join tipoinstrumento t on i.tipo=t.codigo where instrumento = '%s'";
            sql=String.format(sql,i.getSerie());
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                cali.add(calibracion(rs));
            }
        }catch (SQLException e){
            
        }
        return cali;
    }
    
    public List<Calibracion> CalibracionSerch(Instrumento filtro){//retorna una lista de calibraciones de un instrumento
        List<Calibracion> resultado = new ArrayList<Calibracion>();
        try {
            String sql="select * from "+"calibracion c inner join instrumento i on c.instrumento=i.serie"
                    + " inner join tipoinstrumento t on i.tipo=t.codigo "+
                    "where serie like '%%%s%%'";
            sql=String.format(sql,filtro.getSerie());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(calibracion(rs));
            }
        } catch (SQLException ex) { }
        return resultado;       
    } 
    
    
    public int maximoNumeroCalibracion(){
        int resultado = 0;
        try {
            String sql= "select * FROM calibracion ORDER BY numero DESC LIMIT 1;";//SELECT MAX(numero) FROM calibracion
            //sql=String.format(sql,filtro.getSerie());
            ResultSet rs =  db.executeQuery(sql);
            while(rs.next()){
                resultado = rs.getInt("numero");
            }
            
        } catch (SQLException ex) { }
        return resultado;
    }
    
     public void calibracionUpdate(Calibracion p) throws Exception{
        String sql="update calibracion set fecha= '%s',mediciones = '%s',"+
                " where numero='%s'";
        sql=String.format(sql,p.getFecha(),p.getMediciones(),p.getNumero());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Calibracion no existe(update)");
        }
    }
     
      public void calibracionDelete(Calibracion ti) throws Exception{//borro calibracion y medidas de el
        String sql="delete from calibracion where numero='%s'";
        String sql2="delete from medida where calibracion='%s'";
        sql = String.format(sql,ti.getNumero());
        sql2 = String.format(sql2,ti.getNumero());
        int count2=db.executeUpdate(sql2);
        int count=db.executeUpdate(sql);
        if (count==0 && count2==0){
            throw new Exception("Calibracion no existe(borrar)");
        }
    }
     ///////////////////////////////////////////////////////////////////////////
    public void medidaAdd(Medida ti) throws Exception{
        String sql= "insert into medida (calibracion,medida,referencia,lectura) "
                + "values (%d,%d,%d,%d)";
        sql=String.format(sql,ti.getCalibracion().getNumero(),
                ti.getMedida(),ti.getReferencia(),ti.getLectura());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Medida ya existe");
        }  
    }
    public List<Medida> medidasSerch(Calibracion filtro){//retorna una lista de calibraciones de un instrumento
        List<Medida> resultado = new ArrayList<Medida>();
        try {
            String sql="select * from  medida m where m.calibracion= %d";
            sql=String.format(sql,filtro.getNumero());
            ResultSet rs =  db.executeQuery(sql);
            Medida aux;
            while (rs.next()) {
                aux = medida(rs);
                aux.setCalibracion(filtro);
                aux.setNumero(999);
                resultado.add(aux);
            }
        } catch (SQLException ex) { }
        return resultado;       
    } 
    
    
     */


}
