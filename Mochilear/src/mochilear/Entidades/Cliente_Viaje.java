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
public class Cliente_Viaje {
    String cliente;
    String fecha;
    float precio;
    String lugar;
    String fecha_salida;
    String lugar_salida; 
    int campos;

    public Cliente_Viaje() {
    }

    public String getCliente() {
        return cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public float getPrecio() {
        return precio;
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

    public int getCampos() {
        return campos;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    public void setCampos(int campos) {
        this.campos = campos;
    }

    @Override
    public String toString() {
        return "Cliente_Viaje{" + "cliente=" + cliente + ", fecha=" + fecha + ", precio=" + precio + ", lugar=" + lugar + ", fecha_salida=" + fecha_salida + ", lugar_salida=" + lugar_salida + ", campos=" + campos + '}';
    }
    
    
}
