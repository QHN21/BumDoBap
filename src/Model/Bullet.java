package Model;

import Main.ID;

public class Bullet extends GameObject
{
    public Bullet(int x, int y)
    {
        super(x, y, ID.Bullet);
    }

    @Override
    public void tick()
    {

    }
}
