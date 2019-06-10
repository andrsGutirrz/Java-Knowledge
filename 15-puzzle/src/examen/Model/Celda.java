/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.Model;

/**
 *
 * @author Andrés Gutiérrez
 */
public class Celda {
    int numero;
    int estado;//oculto - visible
    public final static int OCULTA = 0;
    public final static int VISIBLE = 1;
    public Celda(){}
    
    public Celda(int numero, int estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public int getEstado() {
        return estado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
