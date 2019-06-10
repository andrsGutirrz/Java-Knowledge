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

public class Viaje {
    String lugar; // referencia a la clase Lugar
    float precio;
    String fecha_salida;// es tipo DATE
    String lugar_salida;

    public Viaje() {
    }

    public Viaje(String lugar, float precio, String fecha_salida, String lugar_salida) {
        this.lugar = lugar;
        this.precio = precio;
        this.fecha_salida = fecha_salida;
        this.lugar_salida = lugar_salida;
    }

    public String getLugar() {
        return lugar;
    }

    public float getPrecio() {
        return precio;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public String getLugar_salida() {
        return lugar_salida;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public void setLugar_salida(String lugar_salida) {
        this.lugar_salida = lugar_salida;
    }

    @Override
    public String toString() {
        return lugar +" | "+ lugar_salida+ " | " + fecha_salida + " | " + precio;
    }
    
    
}
