package Main;

public class ObjectInfo
{
    private int x, y,width,height;
    private boolean running;
    private boolean jumping;
    private boolean direction;
    private ID id;

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
