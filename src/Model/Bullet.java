package Model;

import Main.ID;

public class Bullet extends GameObject
{
    Model model;
    Player player;
    ID bulletID;

    public Bullet(int x, int y,boolean direction,Player player,Model model)
    {
        super(x, y, ID.Bullet);

        this.width = Model.SIZE/2;
        this.height = Model.SIZE/4;
        this.player = player;
        this.bulletID = player.getId();
        this.model = model;

        if(direction) {
            velX = 20;
        }else {
            velX = -20;
            this.x = this.x - Model.SIZE - this.width;
        }
    }

    public void tick()
    {
        moveX();
    }
    private void moveX() {
        x += velX;
        collisionX();
    }
    private void collisionX() {
        //Bullet hits Brick
        for (int i = 0; i < model.bricks.size(); i++) {
            GameObject tempObject = model.bricks.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                model.removeBullet(this);
            }
        }
        //Bullet hits Player
        for (int i = 0; i < model.players.size(); i++) {
            Player tempObject = (Player)model.players.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                if(!tempObject.spawnProtection())
                {
                    player.addPoints();
                    tempObject.gotHit();
                }
                model.removeBullet(this);
            }
        }
    }

    public ID getBulletID()
    {
        return bulletID;
    }
}
