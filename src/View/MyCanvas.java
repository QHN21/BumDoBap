package View;

import Main.ID;
import Main.ObjectInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

public class MyCanvas extends Canvas
{
    Window window;
    ObjectRenderer objectRenderer;

    private final int NORMAL_SIZE = 16;

    private int size;
    private int width;
    private int height;

    private boolean pause = false;

    public MyCanvas(int size)
    {
        this.size = size;
        this.width = 51*size;
        this.height = 29*size;
        this.window = new Window(width, height, "BumDoBap", this);
        this.objectRenderer = new ObjectRenderer(this.size,this.NORMAL_SIZE,this.width,this.height);
    }

    public void render(LinkedList<ObjectInfo> objectsInfo)
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
        objectRenderer.renderObjects(objectsInfo,g);
        if(pause)
            objectRenderer.renderPause(g);
        g.dispose();
        bs.show();
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
