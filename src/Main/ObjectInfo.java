package Main;

public class ObjectInfo
{
    private int x, y,width,height,healthPoints,points;
    private ID id,bulletID;

    public ObjectInfo(int x, int y, int width, int height, ID id)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public ID getId()
    {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ID getBulletID()
    {
        return bulletID;
    }

    public void setBulletID(ID bulletID)
    {
        this.bulletID = bulletID;
    }
}
