package Model;

import Main.ID;

import java.awt.*;

public class Player extends GameObject{

    private Model model;

    private int healthPoints;

    private int points;
    private int gravityTimer;
    private int shootTimer;

    private int respawnX;
    private int respawnY;

    private boolean running;
    private boolean jumping;
    private boolean direction;
    private boolean ducking;
    private boolean shootEnabled;

    public Player(int x, int y, ID id, Model model) {
        super(x, y, id);
        this.respawnX = x;
        this.respawnY = y;
        this.width = Model.SIZE;
        this.height = Model.SIZE*2;
        this.points = 0;
        this.healthPoints = 3;
        this.gravityTimer =  0;
        this.model = model;
        setVelX(0);
        setVelY(0);
    }

    void tick(boolean[] keyDown) {
        interpretKeys(keyDown);
        gravity();
        moveX();
        moveY();
        timer();
    }

    private void interpretKeys(boolean[] keyDown) {
        if (keyDown[0]) {
            jump();
        }
        if (keyDown[1] && !ducking) {
            duck();
        }
        if (!keyDown[1] && ducking) {
            standUp();
        }
        if (keyDown[2] && !keyDown[3]) {
            velX = -Model.SIZE/8;
            setDirection(false);
            if(!isJumping())
                setRunning(true);
        }
        if (!keyDown[2] && keyDown[3]) {
            velX = Model.SIZE/8;
            setDirection(true);
            if(!isJumping())
                setRunning(true);
        }
        if (keyDown[2] && keyDown[3]) {
            velX = 0;
            setRunning(false);
        }
        if (!keyDown[2] && !keyDown[3]) {
            velX = 0;
            setRunning(false);
        }
        if (keyDown[4] && shootEnabled)
        {
            shoot();
            shootEnabled = false;
        }
        if (!keyDown[4])
        {
            shootEnabled = true;
        }

    }

    private void moveX() {
        x += velX;
        collisionX();
    }
    private void moveY() {
        y += velY;
        collisionY();
    }
    private void collisionX() {
        for (int i = 0; i < model.bricks.size(); i++) {
            GameObject tempObject = model.bricks.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                if (this.getX() < tempObject.getX()) {
                    velX = 0;
                    if(velY>1)
                        velY = 1;
                    setX(tempObject.getX() - this.getWidth());
                } else if (this.getX() > tempObject.getX()) {
                    velX = 0;
                    if(velY>1)
                        velY = 1;
                    setX(tempObject.getX() + tempObject.getWidth());
                }
            }
        }
    }
    private void collisionY() {
        for (int i = 0; i < model.bricks.size(); i++) {
            GameObject tempObject = model.bricks.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                if (this.getY() < tempObject.getY()) {
                    velY = 0;
                    setY(tempObject.getY() - this.getHeight());
                } else if (this.getY() > tempObject.getY()) {
                    velY = 0;
                    setY(tempObject.getY() + tempObject.getHeight());
                }
            }
        }
    }

    private void gravity() {
       if(gravityTimer == 8)
       {
           velY += 1;
           if(velY == 1)
               setJumping(false);
           gravityTimer = 0;
       }
    }
    private void jump() {
        if(velY == 0 && !isJumping())
        {
            velY=-Model.SIZE/4;
            setJumping(true);
            gravityTimer = 0;
        }
    }
    private  void shoot() {
        model.addBullet(new Bullet(x + width,y+height/4,isDirection(),this,model));
    }
    private void duck() {
        height = height/2;
        y += height;
        ducking = true;
    }
    private void standUp() {
        y -= height;
        height = 2 * height;
        ducking = false;
    }

    public void addPoints(){points += 100;}
    public void gotHit(){
        healthPoints--;
        if(healthPoints == 0)
        {
            respawn();
            healthPoints = 3;
        }
    }
    private void respawn(){setX(respawnX); setY(respawnY);}
    private void timer() {
        gravityTimer++; shootTimer++;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setJumping(boolean jumping)
    {
        this.jumping = jumping;
    }
    boolean isJumping()
    {
        return jumping;
    }
    public void setRunning(boolean running)
    {
        this.running = running;
    }
    boolean isRunning()
    {
        return running;
    }
    public void setDirection(boolean direction)
    {
        this.direction = direction;
    }
    boolean isDirection()
    {
        return direction;
    }
}
