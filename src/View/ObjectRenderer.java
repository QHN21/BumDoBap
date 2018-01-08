package View;

import Main.ID;
import Main.ObjectInfo;

import java.awt.*;
import java.util.LinkedList;

/**
 * Odpowiada za rysowanie obiektow
 * Rozszerza klase {@link Renderer}
 */
class ObjectRenderer extends Renderer {

    ObjectRenderer(int size, int normalSize, int width, int height){
        super(size,normalSize,width,height);
    }


    /**
     * Otrzymuje jako parametry liste zawierajaca obiekty {@link ObjectInfo}
     * zawierajace informacje o obiektach oraz wartosc timer symbolizujaca czas gry
     * i na ich podstawie renderuje wszystkie obiekty wystepujace podczas gry
     * @param objectsInfo - lista obiektow {@link ObjectInfo}
     * @param g - obiekt Graphics
     * @param timer - czas podany jako int
     */
    void renderObjects(LinkedList<ObjectInfo> objectsInfo, Graphics g,int timer)
    {
        renderTimer(g,timer);
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

    /**
     * Zajmuje sie renderowanie gracza o podanych w argumentach parametrach
     * @param objectInfo - informacje o graczu
     * @param g - obiekt Graphics
     * @param color - kolor gracza
     * @param playerName - nazwa gracza
     * @param hudX - wspolrzedna X HUD'u gracza
     * @param hudY - wspolrzedna Y HUD'u gracza
     */
    private void renderPlayer(ObjectInfo objectInfo, Graphics g, Color color, String playerName, int hudX, int hudY )
    {
        g.setColor(color);
        g.fillRect(scale(objectInfo.getX()),scale(objectInfo.getY()),
                scale(objectInfo.getWidth()),scale(objectInfo.getHeight()/2));
        g.setColor(Color.black);
        g.fillRect(scale(objectInfo.getX()),scale(objectInfo.getY()+objectInfo.getHeight()/2),
                scale(objectInfo.getWidth()),scale(objectInfo.getHeight()/2));
        g.setColor(Color.BLACK);
        if(objectInfo.isDirection()){
            g.fillRect(scale(objectInfo.getX()+objectInfo.getWidth()),
                    scale(objectInfo.getY()+objectInfo.getHeight()/4),
            scale(8),scale(4));
        }
        else
        {
            g.fillRect(scale(objectInfo.getX()-8),
                    scale(objectInfo.getY()+objectInfo.getHeight()/4),
                    scale(8),scale(4));
        }
        g.setFont(new Font("Verdana", Font.PLAIN,scale(8)));
        g.drawString(playerName, hudX, hudY);
        g.drawString("Health: " + Integer.toString(objectInfo.getHealthPoints()), hudX, hudY + scale(16));
        g.drawString("Points: " + Integer.toString(objectInfo.getPoints()), hudX, hudY + scale(32));
    }

    /**
     * Zajmuje sie renderowaniem kuli o podanyhc w argumentach parametrach
     * @param objectInfo - informacje o obiekcie
     * @param g - obiekt Graphics
     */
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

    /**
     * Zajmuje sie renderowaniem cegielek
     * @param objectInfo - informacje o cegielkach
     * @param g - obiekt Graphics
     */
    private void renderBrick(ObjectInfo objectInfo, Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(scale(objectInfo.getX()),scale(objectInfo.getY()),
                scale(objectInfo.getWidth()),scale(objectInfo.getHeight()));
    }

    /**
     * Zajmuje sie renderowaniem timera o podanym jako int czasie w sekundach
     * @param g - obiekt Graphics
     * @param timer - czas
     */
    private void renderTimer(Graphics g,int timer){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.PLAIN,scale(8)));
        g.drawString("Time left: " +Integer.toString(timer) + "s",width/2-scale(48),scale(32));
    }

}
