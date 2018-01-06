package Controller;

import Model.Model;
import View.View;

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
    private boolean game = false;
    private boolean pause = false;
    private boolean exit = false;

    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
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
        model.createGame(4,1);
        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                if(!pause)
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {
        model.tick(view.getKeys());
    }

    private void render()
    {
        view.render(model.sendInfo());
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isGame() {
        return game;
    }

    public void setGame(boolean game) {
        this.game = game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

