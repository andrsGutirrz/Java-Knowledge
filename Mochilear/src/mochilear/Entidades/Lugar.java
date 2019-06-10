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
public class Lugar {
    private int provincia;
    private String nombre;
    private String descripcion;
    private String direccion;
    private double pos_x;
    private double pos_y;

    public Lugar() {
    }

    public Lugar(int provincia, String nombre, String descripcion, String direccion, double pos_x, double pos_y) {
        this.provincia = provincia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }


    public int getProvincia() {
        return provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public String getDireccion() {
        return direccion;
    }

    public double getPos_x() {
        return pos_x;
    }

    public double getPos_y() {
        return pos_y;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPos_x(double pos_x) {
        this.pos_x = pos_x;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public void setPos_y(double pos_y) {
        this.pos_y = pos_y;
    }

    @Override
    public String toString() {
        return nombre +"| "+ descripcion +" | "+direccion;
    }
    
    
    
}
