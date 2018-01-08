package Main;

import Controller.Controller;
import Model.Model;
import View.View;

/**
 * Glowna klasa programu odpowiedzialna za stworzenie
 * obiektow {@link Model} {@link View} i {@link Controller}
 * @author Marcin Kuchenbecker
 */


public class StartApp {
    /**
     * main method of the application
     * @param args
     */
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);
        view.setController(controller);
        controller.start();
    }
}
