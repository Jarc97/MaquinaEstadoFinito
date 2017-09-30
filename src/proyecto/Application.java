/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Controller.Controller;
import model.MaquinaEstadoFinito;
import view.View;


public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaquinaEstadoFinito model = new MaquinaEstadoFinito();
        View view = new View();
        Controller controller = new Controller(model,view);
        view.setVisible(true);
    }
    
}
