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
public class Provincia {
    private int numero;
    private String nombre;

    public Provincia() {
    }

    public Provincia(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public static int convertir(String _provincia){
        int num = 0;
        switch(_provincia){
            case "SAN JOSE": num = 1;
                break;
            case "ALAJUELA": num = 2;
                break;
            case "CARTAGO": num = 3;
                break;
            case "HEREDIA": num = 4;
                break;
            case "GUANACASTE": num = 5;
                break;
            case "PUNTARENAS": num = 6;
                break;
            case "LIMON": num = 7;
                break;
        }
        return num;
    }   
        
}// fin de la clase
