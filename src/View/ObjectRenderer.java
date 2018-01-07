package View;

import Main.ID;
import Main.ObjectInfo;

import java.awt.*;
import java.util.LinkedList;

class ObjectRenderer {

    private int size;
    private int normalSize;
    private int height;
    private int width;
    ObjectRenderer(int size, int normalSize, int width, int height){
        this.size = size;
        this.normalSize = normalSize;
        this.width = width;
        this.height = height;
    }

    void renderObjects(LinkedList<ObjectInfo> objectsInfo, Graphics g)
    {
        for (ObjectInfo tempObjectInfo : objectsInfo) {
            if (tempObjectInfo.getId() == ID.Player1) renderPlayer(tempObjectInfo, g,
                    Color.white, "Player 1", scale(32), scale(32));
            else if (tempObjectInfo.getId() == ID.Player2) renderPlayer(tempObjectInfo, g,
                    Color.green, "Player 2", width - scale(100), scale(32));
            else if (tempObjectInfo.getId() == ID.Player3) renderPlayer(tempObjectInfo, g,
                    Color.yellow, "Player 3", scale(32), height - scale(100));
            else if (tempObjectInfo.getId() == ID.Player4) renderPlayer(tempObjectInfo, g,
                    Color.pink, "Player 4", width - scale(100), height - scale(100));
            else if (tempObjectInfo.getId() == ID.Bullet) renderBullet(tempObjectInfo, g);
            else if (tempObjectInfo.getId() == ID.Brick) renderBrick(tempObjectInfo, g);
        }
    }
    private void renderPlayer(ObjectInfo objectInfo, Graphics g, Color color, String playerName, int hudX, int hudY )
    {
        g.setColor(color);
        g.fillRect(scale(objectInfo.getX()),scale(objectInfo.getY()),
                scale(objectInfo.getWidth()),scale(objectInfo.getHeight()));
        g.setFont(new Font("Verdana", Font.PLAIN,scale(8)));
        g.drawString(playerName, hudX, hudY);
        g.drawString("Health: " + Integer.toString(objectInfo.getHealthPoints()), hudX, hudY + scale(16));
        g.drawString("Points: " + Integer.toString(objectInfo.getPoints()), hudX, hudY + scale(32));
    }
    private void renderBullet(ObjectInfo objectInfo, Graphics g)
    {
        switch (objectInfo.getBulletID()){
            case Player1:
                g.setColor(Color.white);
                break;
            case Player2:
                g.setColor(Color.green);
                break;
            case Player3:
                g.setColor(Color.yellow);
                break;
            case Player4:
                g.setColor(Color.pink);
                break;
        }
        g.fillRect(scale(objectInfo.getX()),scale(objectInfo.getY()),
                scale(objectInfo.getWidth()),scale(objectInfo.getHeight()));
    }
    private void renderBrick(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(scale(objectInfo.getX()),scale(objectInfo.getY()),
                scale(objectInfo.getWidth()),scale(objectInfo.getHeight()));
    }

    private int scale(int x){
        return (int)(x * this.size / this.normalSize);
    }

    public void resize(int size, int width, int height){
        this.size = size;
        this.width = width;
        this.height = height;
    }
}
