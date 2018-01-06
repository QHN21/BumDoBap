package Model;

import Main.ID;

import java.awt.*;

public class Player extends GameObject{

    private Model model;

    private int healthPoints;
    private int points;

    private int gravityTimer;
    private int shootTimer;
    private int spawnProtectionTimer;

    private int respawnX;
    private int respawnY;

    private boolean running;
    private boolean jumping;
    private boolean direction;
    private boolean ducking;
    private boolean standing;
    private boolean duckingEnabled;
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
        this.duckingEnabled = true;
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
        if (keyDown[0] && !ducking) {
            jump();
        }
        if (keyDown[0] && ducking) {
            standUp();
        }
        if (keyDown[1] && (duckingEnabled && !ducking)) {
            duck();
        }
        if(!keyDown[1] && (duckingEnabled && ducking)){
            duckingEnabled = false;
        }
        if (keyDown[1] && (!duckingEnabled && ducking)) {
            standUp();
        }
        if (!keyDown[1] && (!duckingEnabled && !ducking)) {
            duckingEnabled = true;
        }
        if (keyDown[2] && !keyDown[3]) {
            velX = -4;
            setDirection(false);
            if(!isJumping())
                setRunning(true);
        }
        if (!keyDown[2] && keyDown[3]) {
            velX = 4;
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
            shootTimer = 0;
        }
        if (!keyDown[4] && shootTimer > 5)
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
        if(velY > 1)
            setJumping(true);
        collisionY();
    }
    private void collisionX() {
        for (int i = 0; i < model.bricks.size(); i++) {
            GameObject tempObject = model.bricks.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                if (this.getX() < tempObject.getX()) {
                    velX = 0;
                    if(velY>0)
                        velY = 1;
                        setJumping(false);
                    setX(tempObject.getX() - this.getWidth());
                } else if (this.getX() > tempObject.getX()) {
                    velX = 0;
                    if(velY>0)
                        velY = 1;
                        setJumping(false);
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
                    setJumping(false);
                } else if (this.getY() > tempObject.getY()) {
                    velY = 0;
                    setY(tempObject.getY() + tempObject.getHeight());
                }
            }
        }
    }

    private void gravity() {
       if(gravityTimer == 4)
       {
           velY += 1;
           gravityTimer = 0;
       }
    }
    private void jump() {
        if(!isJumping())
        {
            velY=-6;
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

    public void addPoints(){points += 10;}
    public void gotHit(){
        healthPoints--;
        if(healthPoints == 0)
        {
            respawn();
        }
    }
    private void respawn(){
        setX(respawnX);
        setY(respawnY);
        healthPoints = 3;
        spawnProtectionTimer = 0;
    }
    private void timer() {
        gravityTimer++;
        shootTimer++;
        spawnProtectionTimer++;
    }
    public boolean spawnProtection(){
        if(spawnProtectionTimer > 120)
            return false;
        else
            return true;
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
