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

public class AppController implements Runnable {
    private Model model;
    private View view;

    private Thread thread;
    private boolean running = false;

    public AppController(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
        run();
    }

    public void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                view.render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {

    }

}

