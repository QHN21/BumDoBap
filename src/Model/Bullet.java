package Model;

import Main.ID;

public class Bullet extends GameObject
{
    Model model;

    public Bullet(int x, int y,boolean direction,Model model)
    {
        super(x, y, ID.Bullet);

        this.width = Model.SIZE/2;
        this.height = Model.SIZE/4;
        this.model = model;

        if(direction) {
            velX = 5;
        }else {
            velX = -5;
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
            GameObject tempObject = model.players.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                model.removeBullet(this);
            }
        }
    }
}
