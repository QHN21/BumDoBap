package View;

import Main.ID;
import Main.ObjectInfo;
import Model.Model;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;


/**
 * Class: View
 * Creator: Marcin Kuchenbecker
 * Date: 06.11.2017
 * Description:
 * -creates View
 */

public class View extends Canvas
{
    private Model model;
    private Window window;

    private static final int WIDTH = 640, HEIGHT = (WIDTH / 16) * 9;

    public View(Model model)
    {
        this.model = model;
        this.window = new Window(WIDTH, HEIGHT, "BumDoBap", this);
        this.addKeyListener(new KeyInput(this));
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

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        renderObjects(objectsInfo,g);


        g.dispose();
        bs.show();
    }
    public void renderObjects(LinkedList<ObjectInfo> objectsInfo, Graphics g)
    {
        for(int i = 0; i < objectsInfo.size(); i++)
        {
            ObjectInfo tempObjectInfo = objectsInfo.get(i);
            if(tempObjectInfo.getId() == ID.Player1) renderPlayer1(tempObjectInfo, g);
            else if(tempObjectInfo.getId() == ID.Player2) renderPlayer2(tempObjectInfo, g);
            else if(tempObjectInfo.getId() == ID.Player3) renderPlayer3(tempObjectInfo, g);
            else if(tempObjectInfo.getId() == ID.Player4) renderPlayer4(tempObjectInfo, g);
            else if(tempObjectInfo.getId() == ID.Bullet) renderBullet(tempObjectInfo, g);
            else if(tempObjectInfo.getId() == ID.Brick) renderBrick(tempObjectInfo, g);
        }
    }
    public void renderPlayer1(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(objectInfo.getX(),objectInfo.getY(),32,32);
    }
    public void renderPlayer2(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(objectInfo.getX(),objectInfo.getY(),32,32);
    }
    public void renderPlayer3(ObjectInfo objectInfo, Graphics g)
    {

    }
    public void renderPlayer4(ObjectInfo objectInfo, Graphics g)
    {

    }
    public void renderBullet(ObjectInfo objectInfo, Graphics g)
    {

    }
    public void renderBrick(ObjectInfo objectInfo, Graphics g)
    {

    }
}
