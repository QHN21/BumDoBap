package View;

import Controller.Controller;
import Main.GameState;
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
    Menu menu;

    public View()
    {
        this.menu =new Menu(this);
        this.myCanvas = new MyCanvas(24,this, menu);
        this.keyInput = new KeyInput(this, GameState.Menu,menu);
        myCanvas.addKeyListener(keyInput);
    }

    public void render(GameState gameState)
    {
        myCanvas.render(gameState);
    }

    public boolean[][] getKeys(){
        return keyInput.getKeys();
    }

    public void changeGameState(GameState gameState){
        menu.setGameState(gameState);
        controller.setGameState(gameState);
        keyInput.setGameState(gameState);
    }
    public void createGame(int numberOfPlayers){
        controller.createGame(numberOfPlayers);
    }
    public void exit(){
        controller.exit();
        myCanvas.exit();
    }
    public void resize(int size){
        this.myCanvas.resize(size);
    }
    public void getFinalPoints(){

    }
    public int[] getLeaderBoard(){return controller.getLeaderboard();}
    public LinkedList<ObjectInfo> getObjectsInfo(){
        return controller.getObjectsInfo();
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
