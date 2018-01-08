package Controller;

import Main.GameState;
import Main.ObjectInfo;
import Model.Model;
import View.View;

import java.util.LinkedList;

/**
 * Class: Controller
 * Creator: Marcin Kuchenbecker
 * Date: 06.11.2017
 * Description:
 * -creates Controller
 */

public class Controller implements Runnable
{
    private Model model;
    private View view;

    private Thread thread;

    private boolean running = false;

    GameState gameState;

    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        gameState = GameState.Menu;
    }

    public void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

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

    private void tick(boolean[][] keys)
    {
        model.tick(keys);
        if(model.isEndGame()){
            view.changeGameState(GameState.Leaderboard);
        }
    }

    private void render(GameState gameState)
    {
        view.render(gameState);
    }


    public LinkedList<ObjectInfo> getObjectsInfo(){
        return model.sendInfo();
    }
    public int[] getLeaderboard(){ return model.getLeaderBoards();}
    public void setGameState(GameState gameState)
    {
        this.gameState = gameState;
    }
    public void createGame(int numberOfPlayers){
        model.createGame(numberOfPlayers,1);
    }
    public void exit(){
        running = false;
    }
    public boolean isRunning() {
        return running;
    }
    public int getTime(){
        return model.getTime();
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
}

