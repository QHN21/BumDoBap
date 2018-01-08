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

    public int timer;
    boolean endGame;

    private MapCreator mapCreator;
    private PlayerCreator playerCreator;

    public LinkedList<GameObject> players;
    public LinkedList<GameObject> bricks;
    public LinkedList<GameObject> bullets;

    public Model()
    {
        playerCreator = new PlayerCreator(this);
        mapCreator = new MapCreator(this);
    }
    public void createGame(int numberOfPlayers, int mapNumber)
    {
        players = new LinkedList<GameObject>();
        bricks = new LinkedList<GameObject>();
        bullets = new LinkedList<GameObject>();
        playerCreator.createPlayers(numberOfPlayers);
        mapCreator.createMap(mapNumber);
        timer = 0;
        endGame = false;

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
        timer++;
        if(timer >7200){
            endGame = true;
        }
    }

    public void addPlayer(GameObject object)
    {
        this.players.add(object);
    }

    public void addBrick(int x, int y)
    {
        this.bricks.add(new Brick(x,y));
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
            Bullet tempObject = (Bullet)bullets.get(i);
            ObjectInfo tempObjectInfo = new ObjectInfo(tempObject.getX(),tempObject.getY(),
                    tempObject.getWidth(), tempObject.getHeight(),
                    tempObject.getId());
            tempObjectInfo.setBulletID(tempObject.getBulletID());
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
    public boolean isEndGame(){
        return endGame;
    }
    public int[] getLeaderBoards(){
        int[] playerPoints = new int[players.size()];
        for(int i =0; i< players.size(); i++)
        {
            Player tempPlayer = (Player) players.get(i);
            playerPoints[i] = tempPlayer.getPoints();
        }
        return playerPoints;

    }
}
