package Model;

import Main.ID;
import Main.ObjectInfo;

import java.util.LinkedList;

/**
 * Class: Model
 * Creator: Marcin Kuchenbecker
 * Date: 06.11.2017
 * Description:
 * -Creates Model
 */
public class Model
{
    public static final int SIZE = 16;

    private MapCreator mapCreator;
    private PlayerCreator playerCreator;

    public LinkedList<GameObject> players = new LinkedList<GameObject>();
    public LinkedList<GameObject> bricks = new LinkedList<GameObject>();
    public LinkedList<GameObject> bullets = new LinkedList<GameObject>();

    public Model()
    {
        playerCreator = new PlayerCreator(this);
        mapCreator = new MapCreator(this);
    }
    public void createGame(int numberOfPlayers, int mapNumber)
    {
        playerCreator.createPlayers(numberOfPlayers);
        mapCreator.createMap(mapNumber);
    }
    public void tick(boolean[][] keyDown)
    {
        for (int i = 0; i < players.size(); i++)
        {
            Player tempObject = (Player)players.get(i);
            tempObject.tick(keyDown[i]);
        }

        for (int i = 0; i < bullets.size(); i++)
        {
            Bullet tempObject = (Bullet)bullets.get(i);
            tempObject.tick();
        }
    }

    public void addPlayer(GameObject object)
    {
        this.players.add(object);
    }

    public void removePlayer(GameObject object)
    {
        this.players.remove(object);
    }
    public void addBrick(int x, int y)
    {
        this.bricks.add(new Brick(x,y));
    }

    public void removeBrick(GameObject object)
    {
        this.bricks.remove(object);
    }
    public void addBullet(GameObject object)
    {
        this.bullets.add(object);
    }

    public void removeBullet(GameObject object)
    {
        this.bullets.remove(object);
    }

    public LinkedList<ObjectInfo> sendInfo()
    {
        LinkedList<ObjectInfo> objectsInfo = new LinkedList<ObjectInfo>();
        for(int i = 0; i < players.size(); i++)
        {
            Player tempObject = (Player)players.get(i);
            ObjectInfo tempObjectInfo =
                    new ObjectInfo(tempObject.getX(),tempObject.getY(),
                            tempObject.getWidth(), tempObject.getHeight(),
                            tempObject.getId());
            tempObjectInfo.setHealthPoints(tempObject.getHealthPoints());
            tempObjectInfo.setPoints(tempObject.getPoints());

            objectsInfo.add(tempObjectInfo);
        }
        for(int i = 0; i < bullets.size(); i++)
        {
            GameObject tempObject = bullets.get(i);
            ObjectInfo tempObjectInfo = new ObjectInfo(tempObject.getX(),tempObject.getY(),
                    tempObject.getWidth(), tempObject.getHeight(),
                    tempObject.getId());
            objectsInfo.add(tempObjectInfo);
        }
        for(int i = 0; i < bricks.size(); i++)
        {
            GameObject tempObject = bricks.get(i);
            ObjectInfo tempObjectInfo = new ObjectInfo(tempObject.getX(),tempObject.getY(),
                    tempObject.getWidth(), tempObject.getHeight(),
                    tempObject.getId());
            objectsInfo.add(tempObjectInfo);
        }

        return objectsInfo;
    }
}
