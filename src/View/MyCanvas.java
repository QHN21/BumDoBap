package View;

import Main.GameState;
import Main.ID;
import Main.ObjectInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

/**
 * Klasa rozszerza Canvas
 * Odpowiada za wytworzenie "plotna"
 * na ktorym beda rysowane obiekty
 * tworzy i zawiera w sobie obiekty
 * {@link MenuRenderer} i {@link ObjectRenderer}
 * odpowiedzialne za renderowanie menu i obiektow
 */
public class MyCanvas extends Canvas
{

    View view;
    Window window;
    Menu menu;
    MenuRenderer menuRenderer;
    ObjectRenderer objectRenderer;

    private final int NORMAL_SIZE = 16;

    private int size;
    private int width;
    private int height;


    public MyCanvas(int size,View view,Menu menu)
    {
        this.size = size;
        this.width = 52*size;
        this.height = 29*size;
        this.view =view;
        this.window = new Window(width, height, "BumDoBap", this);
        this.menu = menu;
        this.menuRenderer = new MenuRenderer(this.size,this.NORMAL_SIZE,this.width,this.height);
        this.objectRenderer = new ObjectRenderer(this.size,this.NORMAL_SIZE,this.width,this.height);
    }

    /**
     * Przygotowuje plotno do rysowania obiektow.
     * Otrzymuje jako parametr stan gry i w zaleznosci od tego w jakim stanie sie znajduje
     * wywoluje odpowiednia metode do renderowania.
     * @param gameState - stan gry
     */
    public void render(GameState gameState)
    {
       BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.gray);
        g.fillRect(0, 0, width, height);
        if(gameState == GameState.Game)
            objectRenderer.renderObjects(view.getObjectsInfo(),g,view.getTime());
        else if(gameState == GameState.Leaderboard)
            menuRenderer.renderLeaderboard(g,view.getLeaderBoard());
        else
            menuRenderer.render(gameState,menu.getPosition(),g);
        g.dispose();
        bs.show();
    }

    /**
     * Zmienia rozmiar plotna
     * a takze wywoluje metody do zmiany rozmiaru
     * wyswietlanych obiektow w rendererach
     * @param size - rozmiar nowych obiektow w pikselach
     */
    public void resize(int size){
        this.size = size;
        this.width = 52*size;
        this.height = 29*size;
        this.window.resize(width, height);
        this.objectRenderer.resize(size, width,height);
        this.menuRenderer.resize(size, width, height);
    }

    /**
     * Zamyka okno
     */
    public void exit(){
        window.close();
    }
}
