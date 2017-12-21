package Main;

public class ObjectInfo
{
    int x, y;
    boolean running;
    boolean jumping;
    boolean direction;
    ID id;

    public ObjectInfo(int x, int y, ID id)
    {
        this.x = x;
        this.y = y;
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

    public ID getId()
    {
        return id;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }
    public boolean isRunning()
    {
        return running;
    }
    public void setJumping(boolean jumping)
    {
        this.jumping = jumping;
    }
    public boolean isJumping()
    {
        return jumping;
    }
    public void setDirection(boolean direction)
    {
        this.direction = direction;
    }
    public boolean isDirection()
    {
        return direction;
    }

}
