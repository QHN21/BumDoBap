package View;

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
    private MyCanvas myCanvas;

    public boolean[] keyDownP1 = new boolean[5];
    public boolean[] keyDownP2 = new boolean[5];
    public boolean[] keyDownP3 = new boolean[5];
    public boolean[] keyDownP4 = new boolean[5];

    private static final int WIDTH = 1024, HEIGHT = (WIDTH / 16) * 9;

    public View()
    {
        this.myCanvas = new MyCanvas();
        myCanvas.addKeyListener(new KeyInput(this));
    }

    public boolean[][] getKeys()
    {
        boolean[][] KeyDown = {keyDownP1,keyDownP2,keyDownP3,keyDownP4};
        return KeyDown;
    }
    public void render(LinkedList<ObjectInfo> objectsInfo)
    {
        myCanvas.render(objectsInfo);
    }
}
