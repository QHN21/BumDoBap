package Model;

import Main.ID;

/**
 * Klasa umozliwia tworzenie "cegielek"
 * o wspolrzednych x i y
 */
public class Brick extends GameObject
{
    Brick(int x, int y)
    {
        super(x,y, Model.SIZE, Model.SIZE ,ID.Brick);
    }
}
