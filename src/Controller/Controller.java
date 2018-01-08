package Controller;

import Main.GameState;
import Main.ObjectInfo;
import Model.Model;
import View.View;

import java.util.LinkedList;

/**
 * Klasa implementujaca controller w strukturze MVC
 * odpowiedzialna jest za komunikacje miedzy klasami {@link Model} i {@link View}
 */

public class Controller implements Runnable
{

    private Model model;
    private View view;

    private Thread thread;

    private boolean running = false;

    GameState gameState;

    /**
     * Konstruktor zapisuje otrzymane referencje do view i modelu
     * a takze ustawia poczatkowy stan gry na Menu
     * @param view - referencja na view
     * @param model - referencja na model
     */
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        gameState = GameState.Menu;
    }

    /**
     * Tworzy glowny watek aplikacji
     * i rozpoczyna jego dzialanie
     */
    public void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Zatrzymuje glowny watek aplikacji
     * i konczy jej dzialanie
     */
    public void stop()
    {
        try
        {
            thread.join();
            running = false;
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Glowna metoda kontrolera zawierajaca w sobie
     * glowna petle aplikacji
     * Ma ona za zadanie 60 razy na sekunde wywolywac metode tick()
     * oraz render().
     * Dodatkowo wyswietla aktualna liczbe klatek na sekunde
     */
    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                boolean[][] keys = view.getKeys();
                if(gameState == GameState.Game)
                tick(keys);
                delta--;

                if (running)
                    render(gameState);
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }

        }
        stop();
    }

    /**
     * Wywoluje metode tick() w modelu ktorej zadaniem jest zaktualizowanie
     * wszystkich obiektow. Jako parametry otrzymuje tablice tablic przechowywujacych wartosci bool,
     * ktore reprezentuja stan klawiszy
     * true - klawisz zostal wcisniety
     * false - klawisz nie zostal wcisniety
     * @param keys - reprezentuje stan klawiszy
     */
    private void tick(boolean[][] keys)
    {
        model.tick(keys);
        if(model.isEndGame()){
            view.changeGameState(GameState.Leaderboard);
        }
    }

    /**
     * Wywoluje metode render() w {@link View}
     * ktorej zadaniem jest wyrenderowac wszysstkie obiekty na ekranie
     * @param gameState - reprezentuje stan aplikacji
     */
    private void render(GameState gameState)
    {
        view.render(gameState);
    }

    /**
     * Wydaje rozkaz do modelu aby stworzyl nowa gre o podanej liczbie graczy
     * @param numberOfPlayers - liczba graczy
     */
    public void createGame(int numberOfPlayers){
        model.createGame(numberOfPlayers,1);
    }

    /**
     * Ustawia stan gry na podany w argumencie
     * @param gameState - stan w jakim znajduje sie gra
     */
    public void setGameState(GameState gameState)
    {
        this.gameState = gameState;
    }

    /**
     * Pobiera z modelu informacje o czasie trwania gry
     * i ja zwraca
     * @return - zwraca czas gry
     */
    public int getTime(){
        return model.getTime();
    }

    /**
     * Pobiera z modelu informacje o wszystkich obiektach i zapisuje je w
     * liscie obiektow typu {@link ObjectInfo}
     * @return - zwraca liste obiektow typu {@link ObjectInfo}
     */
    public LinkedList<ObjectInfo> getObjectsInfo(){
        return model.sendInfo();
    }

    /**
     * Pobiera z modelu informacje o wnikach graczy
     * @return - zwraca wyniki graczy w tablicy intow
     */
    public int[] getLeaderboard(){ return model.getLeaderBoards();}

    /**
     * Konczy dzialanie aplikacji
     */
    public void exit(){
        running = false;
    }
}

