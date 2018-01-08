package Model;

import Main.ID;

import java.awt.*;

/**
 * Klasa bazowa do wszystkich obiektow w programie
 * zawiera podstawowe informacje jakich podtrzebuje kazdy obiekt
 * (wspolrzedne x i y, szerokosc, wysokosc, predkosc w poziomie i pionie oraz id)
 */
public abstract class GameObject
{
    protected int x, y, width, height;
    protected ID id;
    protected int velX, velY;

    public GameObject(int x, int y, int width, int height, ID id)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    /**
     * Metoda zwraca krawedzie danego obiektu
     * wykorzystywana jest podczas detekcji kolizji
     * @return - krawedzie obiektu w postaci prostokata
     */
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,width,height);
    }

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }
    public void setId(ID id)
    {
        this.id = id;
    }
    public ID getId()
    {
        return id;
    }
    public void setVelX(int velX)
    {
        this.velX = velX;
    }
    public void setVelY(int velY)
    {
        this.velY = velY;
    }
}
