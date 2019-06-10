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

public class Cliente {
    private String nombre;
    private String telefono;
    private String correo;
    private String cedula;
    private String residencia;
    private String observaciones;

    public Cliente(String nombre, String telefono, String correo, String cedula, String residencia, String observaciones) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
        this.residencia = residencia;
        this.observaciones = observaciones;
    }

    
    
    public Cliente() {
    }

    public String getResidencia() {
        return residencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }
    

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public void setTelefono(String numero) {
        this.telefono = numero;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", numero=" + telefono + ", correo=" + correo + ", cedula=" + cedula + '}';
    }
    
}
