/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import examen.Controller.Controller;
import examen.Model.Model;
import examen.View.View;

/**
 *
 * @author Andrés Gutiérrez
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model,view);
        view.setVisible(true);
    }
    
}
