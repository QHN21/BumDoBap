package View;

import Main.ID;
import Main.ObjectInfo;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

public class MyCanvas extends Canvas
{
    Window window;

    private static final int WIDTH = 1024, HEIGHT = (WIDTH / 16) * 9;

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
        g.fillRect(objectInfo.getX(),objectInfo.getY(),objectInfo.getWidth(),objectInfo.getHeight());

        g.setFont(new Font("Verdana", Font.PLAIN,8));
        g.drawString("Player1",0,16);
        g.drawString("Health: " + Integer.toString(objectInfo.getHealthPoints()),0,32);
        g.drawString("Points: " + Integer.toString(objectInfo.getPoints()),0,48);
    }
    public void renderPlayer2(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(objectInfo.getX(),objectInfo.getY(),objectInfo.getWidth(),objectInfo.getHeight());
        g.setFont(new Font("Verdana", Font.PLAIN,8));
        g.drawString("Player2",WIDTH-100,16);
        g.drawString("Health: " + Integer.toString(objectInfo.getHealthPoints()),WIDTH-100,32);
        g.drawString("Points: " + Integer.toString(objectInfo.getPoints()),WIDTH-100,48);
    }
    public void renderPlayer3(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(objectInfo.getX(),objectInfo.getY(),objectInfo.getWidth(),objectInfo.getHeight());
        g.setFont(new Font("Verdana", Font.PLAIN,8));
        g.drawString("Player3",0,HEIGHT-48);
        g.drawString("Health: " + Integer.toString(objectInfo.getHealthPoints()),0,HEIGHT-32);
        g.drawString("Points: " + Integer.toString(objectInfo.getPoints()),0,HEIGHT-16);
    }
    public void renderPlayer4(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.pink);
        g.fillRect(objectInfo.getX(),objectInfo.getY(),objectInfo.getWidth(),objectInfo.getHeight());
        g.setFont(new Font("Verdana", Font.PLAIN,8));
        g.drawString("Player4",WIDTH-100,HEIGHT-48);
        g.drawString("Health: " + Integer.toString(objectInfo.getHealthPoints()),WIDTH-100,HEIGHT-32);
        g.drawString("Points: " + Integer.toString(objectInfo.getPoints()),WIDTH-100,HEIGHT - 16);
    }
    public void renderBullet(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(objectInfo.getX(),objectInfo.getY(),objectInfo.getWidth(),objectInfo.getHeight());
    }
    public void renderBrick(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect(objectInfo.getX(),objectInfo.getY(),objectInfo.getWidth(),objectInfo.getHeight());
    }
}
