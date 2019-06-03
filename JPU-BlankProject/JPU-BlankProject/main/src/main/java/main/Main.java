/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;


import controller.Controller;
import model.Model;
import view.View;


/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
     	Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);
       // view.addListener(controller);
        //model.addObserver(view);

        controller.control();       
    }
}
