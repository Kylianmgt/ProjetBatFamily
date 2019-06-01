/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import contract.IModel;
import contract.IView;
import controller.Controller;
import model.Model;
import view.InputListenner;
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
    	final IModel model = new Model();
        final IView view = new View(model);
       
       
        final Controller controller = new Controller(view, model);
        InputListenner ecouteur = new InputListenner(controller);
        view.setController(controller);

        controller.control();       
    }
}
