package main;

import controller.Controller;
import model.Model;
import view.View;

public abstract class Main {
   
    public static void main(final String[] args) {
     	Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);
        view.getViewFrame().addKeyListener(controller);

        controller.control();       
    }
}
