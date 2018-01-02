package Model;

import Main.ID;

public class Brick extends GameObject
{
    Brick(int x, int y)
    {
        super(x,y, ID.Brick);
        width = Model.SIZE;
        height = Model.SIZE;
    }
}
