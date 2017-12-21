package Model;

import Main.ID;

import java.awt.*;

public class Player extends GameObject{

    boolean running;
    boolean jumping;
    boolean direction;

    int gravity;

    public Player(int x, int y, ID id)
    {
        super(x, y, id);
        this.gravity = 1;
        setVelX(0);
        setVelY(0);
    }

    @Override
    public void tick()
    {
        velY =+ gravity;
    }

    private void gravity()
    {

    }
    public void jump()
    {

    }
    public void shoot()
    {

    }
    public void duck()
    {

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
