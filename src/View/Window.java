package View;

import javax.swing.*;
import java.awt.*;

public class Window {

    JFrame frame;
    MyCanvas myCanvas;

    public Window(int width, int height, String title, MyCanvas myCanvas) {
        this.frame = new JFrame(title);
        this.myCanvas = myCanvas;

        frame.setSize(width,height);
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(myCanvas);

        frame.setVisible(true);
    }

    public void resize(int width, int height){
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
    }
    public void close(){
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }
}
