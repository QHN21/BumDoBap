package View;

import Controller.Controller;
import Main.ObjectInfo;

import java.util.LinkedList;


/**
 * Class: View
 * Creator: Marcin Kuchenbecker
 * Date: 06.11.2017
 * Description:
 * -creates View
 */

public class View
{
    private Controller controller;
    private MyCanvas myCanvas;
    private KeyInput keyInput;

    public View()
    {
        this.myCanvas = new MyCanvas(16);
        this.keyInput = new KeyInput(this);
        myCanvas.addKeyListener(keyInput);
    }

    public boolean[][] getKeys(){
        return keyInput.getKeys();
    }


    public void pause(){
        controller.setPause(true);
        myCanvas.setPause(true);
    }
    public void play(){
        controller.setPause(false);
        myCanvas.setPause(false);
    }
    public void render(LinkedList<ObjectInfo> objectsInfo)
    {
        myCanvas.render(objectsInfo);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
