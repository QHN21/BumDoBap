package View;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends Canvas {

    public Window(int width, int height, String title, View view) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(view);
        frame.setVisible(true);


    }
}
