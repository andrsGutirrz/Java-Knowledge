/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.Controller;

import examen.Model.Celda;
import examen.Model.Model;
import examen.View.View;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Gutiérrez
 */
public class Controller extends MouseAdapter {
    Model model;
    View view;
    public int cont;
    public Controller(Model model, View view)  {
        this.model = model;
        this.view = view;
        cont=0;
        view.setModel(model);
        view.setController(this);
    }
    
   @Override
   public void mouseClicked(MouseEvent e){
        JButton b = ((JButton)e.getSource());
        this.mover(b);
         if(model.hayGanador()){
            JOptionPane.showMessageDialog(view,
            "HA GANADO EN "+ this.cont+" MOVIMIENTOS","FELICIDADES",JOptionPane.INFORMATION_MESSAGE);
        }
   }
   
   
   public void mover(JButton b){
       this.validarMovimiento(b);
   }
   
   
   public void validarMovimiento(JButton b){
       Point coord = (Point)b.getClientProperty("Coordenadas");
       //System.out.println( "("+ coord.x + " , " + coord.y +")");
       int arriba,abajo,iz,der = 0;
       arriba = coord.x - 1;
       abajo = coord.x+1;
       iz = coord.y-1;
       der = coord.y+1;
       int aux;
       if (arriba >= 0 ) {//1 && arriba<4
           if(model.getMatriz()[arriba][coord.y].getNumero() == 16){
              aux =  model.getMatriz()[coord.x][coord.y].getNumero();
              model.getMatriz()[arriba][coord.y].setNumero(aux);model.getMatriz()[arriba][coord.y].setEstado(Celda.VISIBLE);
              model.getMatriz()[coord.x][coord.y].setNumero(16);model.getMatriz()[coord.x][coord.y].setEstado(Celda.OCULTA);
              this.view.setTitle("Quince ("+String.valueOf(++cont)+")");
            }
       }
       if (abajo < 4 ) {//2&& abajo>=0
                if(model.getMatriz()[abajo][coord.y].getEstado() == Celda.OCULTA){
                    aux =  model.getMatriz()[coord.x][coord.y].getNumero();//guardo el numero que toque
                    model.getMatriz()[abajo][coord.y].setNumero(aux);model.getMatriz()[abajo][coord.y].setEstado(Celda.VISIBLE);
                    model.getMatriz()[coord.x][coord.y].setNumero(16);model.getMatriz()[coord.x][coord.y].setEstado(Celda.OCULTA);
                    this.view.setTitle("Quince ("+String.valueOf(++cont)+")");
                } 
       }if (iz >= 0 ) {//3&& iz<4
                if(model.getMatriz()[coord.x][iz].getNumero() == 16){
                    aux =  model.getMatriz()[coord.x][coord.y].getNumero();
                    model.getMatriz()[coord.x][iz].setNumero(aux);model.getMatriz()[coord.x][iz].setEstado(Celda.VISIBLE);
                    model.getMatriz()[coord.x][coord.y].setNumero(16);model.getMatriz()[coord.x][coord.y].setEstado(Celda.OCULTA);
                    this.view.setTitle("Quince ("+String.valueOf(++cont)+")");
            }
       } if(der < 4){//4 && der>=0
                if(model.getMatriz()[coord.x][der].getNumero() == 16){
                    aux =  model.getMatriz()[coord.x][coord.y].getNumero();
                    model.getMatriz()[coord.x][der].setNumero(aux);model.getMatriz()[coord.x][der].setEstado(Celda.VISIBLE);
                    model.getMatriz()[coord.x][coord.y].setNumero(16);model.getMatriz()[coord.x][coord.y].setEstado(Celda.OCULTA);
                    this.view.setTitle("Quince ("+String.valueOf(++cont)+")");
            }
       }
      
      model.notificar();
   }
    
}
