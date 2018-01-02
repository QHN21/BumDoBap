package Main;

import Controller.Controller;
import Model.Model;
import View.View;

/**
 * Class: Main.StartApp
 * Creator: Marcin Kuchenbecker
 * Date: 06.11.2017
 * Description:
 * -First class of the project
 * -Includes main()
 * -Creates MVC
 */


public class StartApp {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller Controller = new Controller(view, model);
        Controller.start();
    }
}
