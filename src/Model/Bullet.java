package Model;

import Main.ID;

/**
 * Zajmuje sie tworzeniem kul wystrzeliwanych przez graczy
 */
public class Bullet extends GameObject
{
    Model model;
    Player player;
    ID bulletID;

    /**
     * Konstruktor tworzy kule o podanych parametrach
     * @param x - wspolrzedna x
     * @param y - wspolrzedna y
     * @param direction - kierunek kuli
     * @param player - gracz ktory wystrzelil kule
     * @param model - referencja na model
     */
    public Bullet(int x, int y,boolean direction,Player player,Model model)
    {
        super(x, y, Model.SIZE/2, Model.SIZE/4,  ID.Bullet);

        this.player = player;
        this.bulletID = player.getId();
        this.model = model;

        if(direction) {
            velX = 10;
        }else {
            velX = -10;
            x -= width;
        }
    }

    /**
     * Jest to metoda wywolywana przez model co kazdy obieg petli programu
     * wywoluje ona metode moveX
     */
    public void tick()
    {
        moveX();
    }

    /**
     * Metoda przemieszcza pocisk w poziomie
     * oraz wywoluje metode detekcji kolizji
     */
    private void moveX() {
        x += velX;
        collisionX();
    }

    /**
     * Sprawdza czy zaszla kolizja zz "cegielka" lub z graczem
     * i w zaleznosci od tego co trafila wywokonuje odpowiednia operacje
     */
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
            if(bulletID != tempObject.getId())
            {
                if (getBounds().intersects(tempObject.getBounds()))
                {
                    if (!tempObject.spawnProtection())
                    {
                        player.addPoints();
                        tempObject.gotHit();
                    }
                    model.removeBullet(this);
                }
            }
        }
    }

    /**
     * Zwraca wartosc bulletID
     * Jest to identyfikator kuli, ktory okresla ktory gracz ja wystrzelil
     * @return - identyfikator kuli
     */
    public ID getBulletID()
    {
        return bulletID;
    }
}
