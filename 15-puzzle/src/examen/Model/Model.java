/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.Model;

import java.util.Collections;
import java.util.Observable;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Gutiérrez
 */
public class Model extends Observable {
     
    public Celda[][] matriz ;
    public static int N = 4;
    public int cont;
    public Stack<Integer> numeros;
    public Model(){ 
        cont = 0;
        numeros = new Stack();
        this.llenarArray();
        matriz = new Celda[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = new Celda(numeros.pop(),Celda.VISIBLE);
            }
        }
        this.ocultar16();
    }

    public Celda[][] getMatriz() {
        return matriz;
    }
    
    public void setEstado(int fila, int columna, int estado){
        matriz[fila][columna].estado = estado;
        setChanged();
        notifyObservers();
    }
    
    public void ocultar16(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if( this.matriz[i][j].getNumero() == 16){
                    this.setEstado(i,j,Celda.OCULTA);
                }
            }
        }
        setChanged();
        notifyObservers();
    }
    
    public void notificar(){
        setChanged();
        notifyObservers();
    }
    
    public boolean hayGanador(){
        int cont = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(this.matriz[i][j].getNumero()!=cont++){
                    return false;
                }
            }
        }
        return true;
    }
    
  
    public void llenarArray(){
        for (int i = 15; i >= 1; i--) {
            this.numeros.add(i);
        }
        Collections.shuffle(numeros);
        numeros.add(0, 16);
    }
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(null); // parametro no usado por ahora
    }
    
}
