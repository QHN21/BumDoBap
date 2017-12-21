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
    private LinkedList<GameObject> players = new LinkedList<GameObject>();
    private LinkedList<GameObject> bricks = new LinkedList<GameObject>();
    private LinkedList<GameObject> bullets = new LinkedList<GameObject>();

    public Model()
    {
        addPlayer(new Player(100, 100, ID.Player1));
        addPlayer(new Player(200, 300, ID.Player2));
    }

    public void tick()
    {
        for (int i = 0; i < bullets.size(); i++)
        {
            GameObject tempObject = bullets.get(i);
            tempObject.tick();
        }

        for (int i = 0; i < players.size(); i++)
        {
            GameObject tempObject = players.get(i);
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
    public void addBrick(GameObject object)
    {
        this.bricks.add(object);
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
            Player tempPlayer = (Player)players.get(i);
            ObjectInfo tempObjectInfo = new ObjectInfo(tempPlayer.getX(),tempPlayer.getY(),tempPlayer.getId());
            tempObjectInfo.setRunning(tempPlayer.isRunning());
            tempObjectInfo.setJumping(tempPlayer.isJumping());
            tempObjectInfo.setDirection(tempPlayer.isDirection());

            objectsInfo.add(tempObjectInfo);
        }
        for(int i = 0; i < bullets.size(); i++)
        {
            GameObject tempBullet = bullets.get(i);
            ObjectInfo tempObjectInfo = new ObjectInfo(tempBullet.getX(),tempBullet.getY(),tempBullet.getId());
            objectsInfo.add(tempObjectInfo);
        }

        return objectsInfo;
    }
}
