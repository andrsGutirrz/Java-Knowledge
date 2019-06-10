/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.Entidades;

/**
 *
 * @author andres
 */
public class Buseta {
    String proveedor;
    int asientos_totales;
    int asientos_disponibles;
    String telefono;
    // Corresponde al FK
    String lugar;
    String fecha_salida;
    String lugar_salida;

    public Buseta() {
    }

    public Buseta(String proveedor, int asientos_totales, int asientos_disponibles,String telefono, String lugar, String fecha_salida, String lugar_salida) {
        this.proveedor = proveedor;
        this.asientos_totales = asientos_totales;
        this.asientos_disponibles = asientos_disponibles;
        this.telefono = telefono;
        this.lugar = lugar;
        this.fecha_salida = fecha_salida;
        this.lugar_salida = lugar_salida;
    }

    public String getProveedor() {
        return proveedor;
    }

    public int getAsientos_totales() {
        return asientos_totales;
    }

    public int getAsientos_disponibles() {
        return asientos_disponibles;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public String getLugar_salida() {
        return lugar_salida;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setAsientos_totales(int asientos_totales) {
        this.asientos_totales = asientos_totales;
    }

    public void setAsientos_disponibles(int asientos_disponibles) {
        this.asientos_disponibles = asientos_disponibles;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public void setLugar_salida(String lugar_salida) {
        this.lugar_salida = lugar_salida;
    }
    
    
    
    
}
