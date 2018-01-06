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
    int Size = 16;

    private int WIDTH = 51*Size, HEIGHT = 29*Size;

    public MyCanvas()
    {
        this.window = new Window(WIDTH, HEIGHT, "BumDoBap", this);
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
            if(tempObjectInfo.getId() == ID.Player1) renderPlayer(tempObjectInfo, g, Color.yellow, "Player 1" , Scale(32), Scale(32) );
            else if(tempObjectInfo.getId() == ID.Player2) renderPlayer(tempObjectInfo, g, Color.green, "Player 2" , WIDTH -Scale(100), Scale(32) );
            else if(tempObjectInfo.getId() == ID.Player3) renderPlayer(tempObjectInfo, g, Color.blue, "Player 3" , Scale(32), HEIGHT - Scale(100) );
            else if(tempObjectInfo.getId() == ID.Player4) renderPlayer(tempObjectInfo, g, Color.pink, "Player 4" , WIDTH - Scale(100), HEIGHT - Scale(100) );
            else if(tempObjectInfo.getId() == ID.Bullet) renderBullet(tempObjectInfo, g);
            else if(tempObjectInfo.getId() == ID.Brick) renderBrick(tempObjectInfo, g);
        }
    }
    public void renderPlayer(ObjectInfo objectInfo, Graphics g, Color color, String playerName, int hudX, int hudY )
    {
        g.setColor(color);
        g.fillRect(Scale(objectInfo.getX()),Scale(objectInfo.getY()),
                   Scale(objectInfo.getWidth()),Scale(objectInfo.getHeight()));
        g.setFont(new Font("Verdana", Font.PLAIN,Scale(8)));
        g.drawString(playerName, hudX, hudY);
        g.drawString("Health: " + Integer.toString(objectInfo.getHealthPoints()), hudX, hudY + Scale(16));
        g.drawString("Points: " + Integer.toString(objectInfo.getPoints()), hudX, hudY + Scale(32));
    }
    public void renderBullet(ObjectInfo objectInfo, Graphics g)
    {
        switch (objectInfo.getBulletID()){
            case Player1:
                g.setColor(Color.yellow);
                break;
            case Player2:
                g.setColor(Color.green);
                break;
            case Player3:
                g.setColor(Color.blue);
                break;
            case Player4:
                g.setColor(Color.pink);
                break;
        }
        g.fillRect(Scale(objectInfo.getX()),Scale(objectInfo.getY()),
                   Scale(objectInfo.getWidth()),Scale(objectInfo.getHeight()));
    }
    public void renderBrick(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(Scale(objectInfo.getX()),Scale(objectInfo.getY()),
                Scale(objectInfo.getWidth()),Scale(objectInfo.getHeight()));
    }

    public int Scale(int x){
        return (int)(x * this.Size / 16);
    }
}
