package View;

import javax.swing.*;
import java.awt.*;

/**
 * Zajmuje sie tworzeniem okna
 */
public class Window {

    JFrame frame;
    MyCanvas myCanvas;

    /**
     * Tworzy nowe okno o podanych parametrach
     * @param width - szerokosc
     * @param height - wysokosc
     * @param title - tytul
     * @param myCanvas - plotno
     */
    public Window(int width, int height, String title, MyCanvas myCanvas) {
        this.frame = new JFrame(title);
        this.myCanvas = myCanvas;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(myCanvas);

        frame.setVisible(true);
    }

    /**
     * zmienia rozmiar okna
     * @param width - szerokosc
     * @param height - wysokosc
     */
    public void resize(int width, int height){
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Zamyka okno
     */
    public void close(){
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }
}
