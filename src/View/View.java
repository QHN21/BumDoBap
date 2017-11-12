package View;

import Model.Model;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Class: View
 * Creator: Marcin Kuchenbecker
 * Date: 06.11.2017
 * Description:
 * -creates View
 */

public class View extends Canvas {
    private Model model;
    private Window window;

    private static final int WIDTH = 640, HEIGHT = (WIDTH / 16) * 9;

    public View(Model model) {
        this.model = model;
        this.window = new Window(WIDTH, HEIGHT, "BumDoBap", this);
        this.addKeyListener(new KeyInput());
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.green);
        g.fillRect(0,0,WIDTH,HEIGHT);

        model.render(g);

        g.dispose();
        bs.show();
    }
}
