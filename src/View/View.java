package View;

import Controller.Controller;
import Main.GameState;
import Main.ObjectInfo;

import java.util.LinkedList;


/**
Klasa view odpowiada za storzenie interfejsu uzytkownika
 klasa laczy sie z {@link Controller} za pomoca swoich metod
 i przechowywanej w sobie referencji na kontroler.
 Zajmuje sie takze sterowaniem plotna {@link MyCanvas} oraz
 {@link KeyInput}
 */

public class View
{
    private Controller controller;
    private MyCanvas myCanvas;
    private KeyInput keyInput;
    Menu menu;

    /**
     * Konstruktor View
     * tworzy obiekt View oraz jego podobiekty
     * Menu
     * MyCanvas
     * KeyInput
     * i laczy KeyInput z MyCanvas
     */
    public View()
    {
        this.menu =new Menu(this);
        this.myCanvas = new MyCanvas(24,this, menu);
        this.keyInput = new KeyInput(this, GameState.Menu,menu);
        myCanvas.addKeyListener(keyInput);
    }

    /**
     * Wywoluje metode render z {@link MyCanvas}
     * @param gameState - stan gry
     */
    public void render(GameState gameState)
    {
        myCanvas.render(gameState);
    }

    /**
     * Pobiera z {@link KeyInput} tablice klawiszy i zwraca ja
     * @return tablica tablic boolean
     */
    public boolean[][] getKeys(){
        return keyInput.getKeys();
    }

    /**
     * Zmienia stan gry w menu controllerze i keyInput
     * @param gameState - stan gry
     */
    public void changeGameState(GameState gameState){
        menu.setGameState(gameState);
        controller.setGameState(gameState);
        keyInput.setGameState(gameState);
    }

    /**
     * Wywoluje metode createGame() w {@link Controller}
     * @param numberOfPlayers - liczba graczy
     */
    public void createGame(int numberOfPlayers){
        controller.createGame(numberOfPlayers);
    }

    /**
     * Wylacza gre
     */
    public void exit(){
        controller.exit();
        myCanvas.exit();
    }

    /**
     * Wywoluje metode resize() {@link MyCanvas}
     * @param size - rozmiar
     */
    public void resize(int size){
        this.myCanvas.resize(size);
    }

    /**
     * Wywoluje metode getTime() z {@link Controller}
     * @return
     */
    public int getTime(){
        return controller.getTime();
    }
    /**
     * Wywoluje metode getLEaderboard() z {@link Controller}
     * @return
     */
    public int[] getLeaderBoard(){return controller.getLeaderboard();}
    /**
     * Wywoluje metode getObjectInfo z {@link Controller}
     * @return
     */
    public LinkedList<ObjectInfo> getObjectsInfo(){
        return controller.getObjectsInfo();
    }

    /**
     * Ustawia controller
     * @param controller - referencja na controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
