package Model;

import Main.ID;

import java.awt.*;

/**
 * Klasa ma za zadanie tworzenie graczy
 * oraz obsluge ich fizyki poruszania a takze strzelania.
 */
public class Player extends GameObject{

    private Model model;

    private int healthPoints;
    private int points;

    private int gravityTimer;
    private int shootTimer;
    private int spawnProtectionTimer;

    private int respawnX;
    private int respawnY;

    private boolean jumping;
    private boolean direction;
    private boolean ducking;

    private boolean duckingEnabled;
    private boolean shootEnabled;

    /**
     * Tworzy gracza o podanych parametrach
     * @param x - wspolrzedna x
     * @param y - wspolrzedna y
     * @param id - identyfikator
     * @param model - referencja na model
     */
    public Player(int x, int y, ID id, Model model) {
        super(x, y, Model.SIZE, Model.SIZE*2, id);
        this.velX = 0;
        this.velY = 0;
        this.respawnX = x;
        this.respawnY = y;
        this.points = 0;
        this.healthPoints = 3;
        this.gravityTimer =  0;
        this.duckingEnabled = true;
        this.model = model;
    }

    /**
     * Metoda wywolywana przez model w kazdym obiegu petli.
     * i wywoluje metody moveX() oraz moveY(), a takze
     * interpretKeys(), gravity() oraz timer()
     * @param keyDown - tablica wartosci o typie boolean przechowujaca informacje o wcisnietych klawiszach
     */
    void tick(boolean[] keyDown) {
        interpretKeys(keyDown);
        gravity();
        moveX();
        moveY();
        timer();
    }

    /**
     * Metoda interpretuje otrzymana tablice wcisnietych klawiszy
     * i na jej podstawie wykonuje odpowiednie operacje
     * Miejsca w  tablicy odpowiadaja:
     * 0 - klawisz skoku
     * 1 - klawisz kucania
     * 2 - klawisz ruchu w lewo
     * 3 - klawisz ruchu w prawo
     * 4 - klawisz strzelania
     * @param keyDown - tablica klawiszy
     */
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
            direction =false;
        }
        if (!keyDown[2] && keyDown[3]) {
            velX = 4;
            direction = true;
        }
        if (keyDown[2] && keyDown[3]) {
            velX = 0;
        }
        if (!keyDown[2] && !keyDown[3]) {
            velX = 0;
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

    /**
     * Metoda odpowiada za poruszanie sie gracza w poziomie
     * oraz wywoluje metode sprawdzajaca kolizje
     */
    private void moveX() {
        x += velX;
        collisionX();
    }
    /**
     * Metoda odpowiada za poruszanie sie gracza w pionie
     * oraz wywoluje metode sprawdzajaca kolizje
     */
    private void moveY() {
        y += velY;
        if(velY > 1)
            jumping = true;
        collisionY();
    }

    /**
     * Sprawdza kolizje w poziomie
     * i koryguje jego parametry gdy kolizja nastapi
     */
    private void collisionX() {
        for (int i = 0; i < model.bricks.size(); i++) {
            GameObject tempObject = model.bricks.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                if (x < tempObject.getX()) {
                    velX = 0;
                    if(velY>0)
                        velY = 1;
                    jumping =false;
                    x = tempObject.getX() - this.getWidth();
                } else if (x > tempObject.getX()) {
                    velX = 0;
                    if(velY>0)
                        velY = 1;
                    jumping = false;
                    x = tempObject.getX() + tempObject.getWidth();
                }
            }
        }
    }
    /**
     * Sprawdza kolizje w pionie
     * i koryguje jego parametry gdy kolizja nastapi
     */
    private void collisionY() {
        for (int i = 0; i < model.bricks.size(); i++) {
            GameObject tempObject = model.bricks.get(i);
            if (getBounds().intersects(tempObject.getBounds())) {
                if (y < tempObject.getY()) {
                    velY = 0;
                    y = tempObject.getY() - this.getHeight();
                    jumping = false;
                } else if (y > tempObject.getY()) {
                    velY = 0;
                    y = tempObject.getY() + tempObject.getHeight();
                }
            }
        }
    }

    /**
     * Odpowiada za grawitacje.
     * Wykorzystywany w niej gravityTimer odmierza obiegi petli,
     * aby co czwarty obieg zwiekszyc predkosc w dol o 1
     */
    private void gravity() {
       if(gravityTimer == 4)
       {
           velY += 1;
           gravityTimer = 0;
       }
    }

    /**
     * Odpowiada za skok.
     * Skok reprezentowany jest w programie
     * jako nagla zmiana predkosci gracza w gore
     */
    private void jump() {
        if(!jumping)
        {
            velY=-6;
            jumping = true;
            gravityTimer = 0;
        }
    }

    /**
     * Odpowiada za strzelanie.
     * Strzal odbywa sie jako dodanie kuli do modelu o odpowiednich wspolrzednych i kierunku
     */
    private  void shoot() {
        model.addBullet(new Bullet(x + width/2,y+height/4,direction,this,model));
    }

    /**
     * Odpowiada za kucanie.
     * Kucanie zaimplementowane jest jako zmniejszanie wysokosci gracza o polowe
     */
    private void duck() {
        height = height/2;
        y += height;
        ducking = true;
    }

    /**
     * Odpowiada za wstawanie.
     * Zaimplementowane jest jako przywracanie wysokosci gracza
     * do stanu podstawowego po kucnieciu
     */
    private void standUp() {
        y -= height;
        height = 2 * height;
        ducking = false;
    }

    /**
     * Metoda dodaje punkty graczowi.
     * Wywolywana jest przez pocisk gdy ten trafi w cel
     */
    public void addPoints(){points += 10;}

    /**
     * ODpowiada za otrzymywanie obrazen.
     * Wywolywana jest gdy w gracza trafi pocisk
     */
    public void gotHit(){
        healthPoints--;
        if(healthPoints == 0)
        {
            respawn();
        }
    }

    /**
     * Odpowiada za respawn gracza gdy ten zginie
     */
    private void respawn(){
        x = respawnX;
        y = respawnY;
        healthPoints = 3;
        spawnProtectionTimer = 0;
    }

    /**
     * Odmierza ilosc petli programu dla kazdego z potrzebnych licznikow
     */
    private void timer() {
        gravityTimer++;
        shootTimer++;
        spawnProtectionTimer++;
    }

    /**
     * Odpowiada za ochrone gracza po respawnie.
     * Zwraca true gdy ochrona jest aktywna
     * @return
     */
    public boolean spawnProtection(){
        return spawnProtectionTimer <= 120;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    public int getPoints() {
        return points;
    }
    boolean isDirection()
    {
        return direction;
    }
}
